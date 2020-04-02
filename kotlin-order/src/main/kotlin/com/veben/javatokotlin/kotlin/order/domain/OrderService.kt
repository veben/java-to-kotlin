package com.veben.javatokotlin.kotlin.order.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService(
        private var orderRepository: OrderRepository,
        private var lineOrderRepository: LineOrderRepository) {

    fun findAllOrders(): Set<PassedOrder> {
        return orderRepository.findAllOrders()
    }

    fun findLineOrdersForOrder(orderId: String): List<LineOrder>  {
        return lineOrderRepository.findLineOrdersForOrder(orderId)
    }
}
