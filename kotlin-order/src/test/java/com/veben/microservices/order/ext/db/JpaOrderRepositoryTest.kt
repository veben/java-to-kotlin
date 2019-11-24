package com.veben.microservices.order.ext.db

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class JpaOrderRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    private lateinit var jpaPassedOrderRepository: JpaPassedOrderRepository

    @Test
    fun `should find all orders when data`() {
        // given

        // when
        val allOrders = jpaPassedOrderRepository.findAllPassedOrders()

        // then
        assert(allOrders.isNotEmpty())
    }
}