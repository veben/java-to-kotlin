package com.veben.microservices.order.ext.db;

import com.veben.microservices.order.domain.PassedOrder;
import com.veben.microservices.order.ext.db.config.AbstractRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class JpaOrderRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    @Test
    void should_find_all_orders_when_data() {
        // given

        // when
        Set<PassedOrder> allOrders = jpaOrderRepository.findAllOrders();

        // then
        assertThat(allOrders).isNotEmpty();
    }
}