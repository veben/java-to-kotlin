package com.veben.microservices.order.ext.db

import com.veben.microservices.order.domain.PassedOrder
import com.veben.microservices.order.domain.PassedOrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import java.util.UUID
import kotlin.jvm.JvmDefault

@Repository
interface JpaPassedOrderRepository : PassedOrderRepository, JpaRepository<PassedOrder, UUID> {

    @JvmDefault
    override fun findAllPassedOrders(): Set<PassedOrder> {
        return HashSet(findAll())
    }
}
