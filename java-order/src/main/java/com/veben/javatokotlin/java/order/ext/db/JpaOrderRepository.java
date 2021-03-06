package com.veben.javatokotlin.java.order.ext.db;

import com.veben.javatokotlin.java.order.domain.PassedOrder;
import com.veben.javatokotlin.java.order.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public interface JpaOrderRepository extends OrderRepository, JpaRepository<PassedOrder, UUID> {

    default Set<PassedOrder> findAllOrders() {
        return new HashSet<>(findAll());
    }
}
