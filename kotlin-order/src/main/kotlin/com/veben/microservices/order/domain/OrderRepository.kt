package com.veben.microservices.order.domain

interface OrderRepository {
    fun findAllOrders(): Set<PassedOrder>
}
