package com.veben.microservices.order.ext.rest


import com.veben.microservices.order.domain.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime.now

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [OrderController::class])
internal class PassedOrderControllerTest {

    companion object {
        private const val ORDER_PATH = "/api/order/v1/orders/"
        private const val LINE_ORDERS_FOR_ORDER_URI = "/line-orders"
    }

    @MockBean
    private lateinit var orderService: OrderService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun should_return_no_content_when_no_order() {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().`is`(HttpStatus.NO_CONTENT.value()))
    }

    @Test
    fun should_return_ok_when_order() {
        // given
        val order = PassedOrder(Buyer("jean-michel@gmail.com", "Dupont", "Jean-Michel",
                Address("France", "Paris", "Lombard", 10)),
                now())
        `when`(orderService.findAllOrders()).thenReturn(setOf(order))

        // when
        mockMvc.perform(get(ORDER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk)
    }

    @Test
    fun should_return_no_content_when_no_line_order() {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH + "id" + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().`is`(HttpStatus.NO_CONTENT.value()))
    }

    @Test
    fun should_return_ok_when_no_line_order() {
        // given
        val orderId = "id"
        val lineOrder = LineOrder("Bike", 1, PassedOrder())
        `when`(orderService.findLineOrdersForOrder(anyString())).thenReturn(listOf(lineOrder))

        // when
        mockMvc.perform(get(ORDER_PATH + orderId + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk)
    }
}