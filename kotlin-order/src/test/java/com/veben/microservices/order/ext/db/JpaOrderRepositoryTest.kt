package com.veben.microservices.order.ext.db

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class JpaOrderRepositoryTest : AbstractRepositoryTest() {

    @Autowired
    private lateinit var jpaPassedOrderRepository: JpaPassedOrderRepository

    @Test
    fun should_find_all_orders_when_data() {
        // given

        // when
        val allOrders = jpaPassedOrderRepository.findAllPassedOrders()

        // then
        assertThat(allOrders).isNotEmpty
    }
}