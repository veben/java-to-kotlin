package com.veben.javatokotlin.kotlin.order.domain

interface LineOrderRepository {
    fun findLineOrdersForOrder(parentOrderId: String): List<LineOrder>
}