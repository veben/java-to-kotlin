package com.veben.microservices.order.ext.rest

import com.veben.microservices.order.domain.LineOrder
import com.veben.microservices.order.domain.OrderService
import com.veben.microservices.order.domain.PassedOrder
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/order/v1")
@Api(value = "order")
class OrderController(private var orderService: OrderService) {

    @GetMapping("/orders")
    @ApiOperation(value = "List orders", response = PassedOrder::class, responseContainer = "ResponseEntity")
    fun findAllOrders(): ResponseEntity<Set<PassedOrder>> {
//        log.info("findAllOrders called")

        val orders = orderService.findAllOrders()

        return if (orders.isEmpty()) ResponseEntity.noContent().build() else ResponseEntity.ok(orders)
    }

    @GetMapping("/orders/{orderId}/line-orders")
    @ApiOperation(value = "List lines for an order", response = PassedOrder::class, responseContainer = "ResponseEntity")
    fun findLineOrdersForOrder(@PathVariable("orderId") orderId: String): ResponseEntity<List<LineOrder>> {
        //log.info("findLineOrdersForOrder called with params: $orderId")

        val lineOrders = orderService.findLineOrdersForOrder(orderId)

        return if (lineOrders.isEmpty()) ResponseEntity.noContent().build() else ResponseEntity.ok(lineOrders)
    }
}
