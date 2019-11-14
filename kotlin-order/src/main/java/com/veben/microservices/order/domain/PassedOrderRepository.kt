package com.veben.microservices.order.domain

interface PassedOrderRepository {
    fun findAllPassedOrders(): Set<PassedOrder>
}
