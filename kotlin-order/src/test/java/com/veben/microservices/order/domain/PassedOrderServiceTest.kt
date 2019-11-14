package com.veben.microservices.order.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime.now

@ExtendWith(MockitoExtension::class)
internal class PassedOrderServiceTest {

    @Mock
    private lateinit var passedOrderRepository: PassedOrderRepository
    @Mock
    private lateinit var lineOrderRepository: LineOrderRepository

    @InjectMocks
    private lateinit var orderService: OrderService

    @Test
    fun should_find_all_orders_when_data() {
        // given
        val order = PassedOrder(
                Buyer("jean-michel@gmail.com", "Dupont", "Jean-Michel",
                        Address("France", "Paris", "Lombard", 10)), now())
        `when`(passedOrderRepository.findAllPassedOrders()).thenReturn(setOf(order))

        // then
        val actualOrders = orderService.findAllOrders()

        // then
        assertThat(actualOrders).containsExactly(order)
    }

    @Test
    fun should_find_line_orders_for_order_when_data() {
        // given
        val orderId = "id"
        val lineOrder = LineOrder("Bike", 1)
        `when`(lineOrderRepository.findLineOrdersForOrder(orderId)).thenReturn(listOf(lineOrder))

        // then
        val actualLineOrders = orderService.findLineOrdersForOrder(orderId)

        // then
        assertThat(actualLineOrders).containsExactly(lineOrder)
    }
}