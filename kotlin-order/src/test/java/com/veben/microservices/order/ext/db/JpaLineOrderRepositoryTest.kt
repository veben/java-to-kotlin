package com.veben.microservices.order.ext.db

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class JpaLineOrderRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    private lateinit var jpaLineOrderRepository: JpaLineOrderRepository

    @Test
    fun should_find_line_orders_for_existing_order() {
        // given
        val orderId = "c5a659c3-5ba1-42bb-b1fb-b35d4f589f34"

        // when
        val lineOrders = jpaLineOrderRepository.findLineOrdersForOrder(orderId)

        // then
        assertThat(lineOrders).isNotEmpty
    }
}