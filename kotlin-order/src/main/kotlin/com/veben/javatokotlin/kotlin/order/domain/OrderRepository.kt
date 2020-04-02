package com.veben.javatokotlin.kotlin.order.domain

interface OrderRepository {
    fun findAllOrders(): Set<PassedOrder>
}
