package com.veben.javatokotlin.kotlin.order.ext.rest


import com.veben.javatokotlin.kotlin.order.domain.*
import com.veben.javatokotlin.kotlin.order.domain.OrderService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime.now

@WebMvcTest
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
    fun `should return no content when no order`() {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isNoContent)
    }

    @Test
    fun `should return ok when order`() {
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
    fun `should return no content when no line order`() {
        // given

        // when
        mockMvc.perform(get(ORDER_PATH + "id" + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isNoContent)
    }

    @Test
    fun `should return ok when no line order`() {
        // given
        val orderId = "id"
        val lineOrder = LineOrder("Bike", 1)
        `when`(orderService.findLineOrdersForOrder(anyString())).thenReturn(listOf(lineOrder))

        // when
        mockMvc.perform(get(ORDER_PATH + orderId + LINE_ORDERS_FOR_ORDER_URI))
                .andDo(MockMvcResultHandlers.print())
                // then
                .andExpect(status().isOk)
    }
}