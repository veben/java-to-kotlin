package com.veben.javatokotlin.java.order.ext.rest;

import com.veben.javatokotlin.java.order.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class OrderControllerTest {

    private static final String ORDER_PATH = "/api/order/v1/orders/";
    private static final String LINE_ORDERS_FOR_ORDER_URI = "/line-orders";

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_no_content_when_no_order() throws Exception {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    void should_return_ok_when_order() throws Exception {
        // given
        var order = new PassedOrder(
                new Buyer(
                        "jean-michel@gmail.com", "Dupont", "Jean-Michel",
                        new Address("France", "Paris", "Lombard", 10)),
                now());
        when(orderService.findAllOrders()).thenReturn(Set.of(order));

        // when
        mockMvc.perform(get(ORDER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }

    @Test
    void should_return_no_content_when_no_line_order() throws Exception {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH + "id" + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    void should_return_ok_when_no_line_order() throws Exception {
        // given
        String orderId = "id";
        var lineOrder = new LineOrder("Bike", 1);
        when(orderService.findLineOrdersForOrder(anyString())).thenReturn(List.of(lineOrder));

        // when
        mockMvc.perform(get(ORDER_PATH + orderId + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk());
    }
}