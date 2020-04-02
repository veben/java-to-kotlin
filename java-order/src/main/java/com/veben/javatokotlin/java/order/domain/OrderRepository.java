package com.veben.javatokotlin.java.order.domain;

import java.util.Set;

public interface OrderRepository {
    Set<PassedOrder> findAllOrders();
}
