package com.veben.microservices.order

import mu.KotlinLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class OrderApplication {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val logger = KotlinLogging.logger {}

            SpringApplication.run(OrderApplication::class.java, *args)

            logger.info("**********************************************************************")
            logger.info("Order Mircroservice from veben is UP")
            logger.info("Health check is available at http://localhost:8091/actuator/health")
            logger.info("Swagger is available at http://localhost:8091/swagger-ui.html")
            logger.info("Database is available at jdbc:postgresql://localhost:5434/order")
            logger.info("**********************************************************************")
        }
    }
}
