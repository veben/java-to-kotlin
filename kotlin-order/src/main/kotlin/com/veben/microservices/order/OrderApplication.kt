package com.veben.microservices.order

import mu.KotlinLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class OrderApplication

fun main(args: Array<String>) {
    val context = SpringApplication.run(OrderApplication::class.java, *args)
    logStartupInformations(context)
}

private fun logStartupInformations(context: ConfigurableApplicationContext) {
    val logger = KotlinLogging.logger {}

    val protocol = context.environment.getProperty("application.protocol")
    val host = context.environment.getProperty("application.host")
    val port = context.environment.getProperty("server.port")
    val name = context.environment.getProperty("spring.application.name")

    logger.info("**********************************************************************")
    logger.info("[{}] ℳicroservice from veben is UP", context.environment.getProperty("spring.application.name"))
    logger.info("Health check is available at {}://{}:{}/actuator/health", protocol, host, port)
    logger.info("Swagger is available at {}://{}:{}/swagger-ui.html", protocol, host, port)
    logger.info("Database is available using jdbc:postgresql://{}:5433/{}", host, name)
    logger.info("**********************************************************************")
}
