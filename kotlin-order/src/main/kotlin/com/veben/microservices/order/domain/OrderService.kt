package com.veben.microservices.order.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService(
        private var passedOrderRepository: PassedOrderRepository,
        private var lineOrderRepository: LineOrderRepository) {

    fun findAllOrders(): Set<PassedOrder> {
        return passedOrderRepository.findAllPassedOrders()
    }

    fun findLineOrdersForOrder(orderId: String): List<LineOrder> {
        return lineOrderRepository.findLineOrdersForOrder(orderId)
    }
}
