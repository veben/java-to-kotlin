package com.veben.javatokotlin.java.order.ext.rest;

import com.veben.javatokotlin.java.order.domain.LineOrder;
import com.veben.javatokotlin.java.order.domain.OrderService;
import com.veben.javatokotlin.java.order.domain.PassedOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/order/v1")
@Api(value = "order")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/orders")
    @ApiOperation(value = "List orders", response = PassedOrder.class, responseContainer = "ResponseEntity")
    public ResponseEntity<Set<PassedOrder>> findAllOrders() {
        log.info("findAllOrders called");

        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping(value = "/orders/{orderId}/line-orders")
    @ApiOperation(value = "List lines for an order", response = PassedOrder.class, responseContainer = "ResponseEntity")
    public ResponseEntity<List<LineOrder>> findLineOrdersForOrder(@PathVariable("orderId") String orderId) {
        log.info("findLineOrdersForOrder called with params: " + orderId);

        return ResponseEntity.ok(orderService.findLineOrdersForOrder(orderId));
    }
}
