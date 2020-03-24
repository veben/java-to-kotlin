package com.veben.microservices.order.ext.db

import com.veben.microservices.order.ext.db.config.AbstractRepositoryTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class JpaLineOrderRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    private lateinit var repository: JpaLineOrderRepository

    @Test
    fun `should find line orders for existing order`() {
        // given
        val orderId = "c5a659c3-5ba1-42bb-b1fb-b35d4f589f34"

        // when
        val lineOrders = repository.findLineOrdersForOrder(orderId)

        // then
        assert(lineOrders.isNotEmpty())
    }
}