package com.veben.javatokotlin.kotlin.order.ext.rest

import com.veben.javatokotlin.kotlin.order.domain.LineOrder
import com.veben.javatokotlin.kotlin.order.domain.OrderService
import com.veben.javatokotlin.kotlin.order.domain.PassedOrder
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/order/v1")
@Api(value = "order")
class OrderController(private var orderService: OrderService) {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/orders")
    @ApiOperation(value = "List orders", response = PassedOrder::class, responseContainer = "ResponseEntity")
    fun findAllOrders(): ResponseEntity<Set<PassedOrder>> {
        logger.info("findAllOrders called")

        return ResponseEntity.ok(orderService.findAllOrders())
    }

    @GetMapping("/orders/{orderId}/line-orders")
    @ApiOperation(value = "List lines for an order", response = PassedOrder::class, responseContainer = "ResponseEntity")
    fun findLineOrdersForOrder(@PathVariable("orderId") orderId: String): ResponseEntity<List<LineOrder>> {
        logger.info("findLineOrdersForOrder called with params: $orderId")

        return ResponseEntity.ok(orderService.findLineOrdersForOrder(orderId))
    }
}
