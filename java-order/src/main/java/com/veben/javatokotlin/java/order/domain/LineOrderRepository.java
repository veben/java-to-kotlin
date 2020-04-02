package com.veben.javatokotlin.java.order.domain;

import java.util.List;

public interface LineOrderRepository {
    List<LineOrder> findLineOrdersForOrder(String orderId);
}
