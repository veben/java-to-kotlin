package com.veben.microservices.order.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
open class OrderService(
        private var passedOrderRepository: PassedOrderRepository,
        private var lineOrderRepository: LineOrderRepository) {

    open fun findAllOrders(): Set<PassedOrder> {
        return passedOrderRepository.findAllPassedOrders()
    }

    open fun findLineOrdersForOrder(orderId: String): List<LineOrder> {
        return lineOrderRepository.findLineOrdersForOrder(orderId)
    }
}
