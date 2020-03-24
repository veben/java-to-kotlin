package com.veben.microservices.order.ext.db

import com.veben.microservices.order.ext.db.config.AbstractRepositoryTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class JpaOrderRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    private lateinit var repository: JpaOrderRepository

    @Test
    fun `should find all orders when data`() {
        // given

        // when
        val allOrders = repository.findAllOrders()

        // then
        assert(allOrders.isNotEmpty())
    }
}