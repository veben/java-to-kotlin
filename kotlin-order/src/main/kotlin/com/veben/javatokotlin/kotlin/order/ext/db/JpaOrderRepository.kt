package com.veben.javatokotlin.kotlin.order.ext.db

import com.veben.javatokotlin.kotlin.order.domain.PassedOrder
import com.veben.javatokotlin.kotlin.order.domain.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.Set

@Repository
interface JpaOrderRepository : OrderRepository, JpaRepository<PassedOrder, UUID> {

    @JvmDefault
    override fun findAllOrders(): Set<PassedOrder> {
        return HashSet(findAll())
    }
}