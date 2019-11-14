package com.veben.microservices.order.domain

interface LineOrderRepository {
    fun findLineOrdersForOrder(parentOrderId: String): List<LineOrder>
}
