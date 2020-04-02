package com.veben.javatokotlin.kotlin.order.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime.now

@ExtendWith(MockitoExtension::class)
internal class PassedOrderServiceTest {

    private val passedOrderRepository = Mockito.mock(OrderRepository::class.java)
    private val lineOrderRepository = Mockito.mock(LineOrderRepository::class.java)

    @InjectMocks
    private lateinit var orderService: OrderService

    @Test
    fun `should find all orders when data`() {
        // given
        val order = PassedOrder(
                Buyer("jean-michel@gmail.com", "Dupont", "Jean-Michel",
                        Address("France", "Paris", "Lombard", 10)), now())
        `when`(passedOrderRepository.findAllOrders()).thenReturn(setOf(order))

        // then
        val actualOrders = orderService.findAllOrders()

        // then
        assert(actualOrders.contains(order))
    }

    @Test
    fun `should find line orders for order when data`() {
        // given
        val orderId = "id"
        val lineOrder = LineOrder("Bike", 1)
        `when`(lineOrderRepository.findLineOrdersForOrder(orderId)).thenReturn(listOf(lineOrder))

        // then
        val actualLineOrders = orderService.findLineOrdersForOrder(orderId)

        // then
        assert(actualLineOrders.contains(lineOrder))
    }
}