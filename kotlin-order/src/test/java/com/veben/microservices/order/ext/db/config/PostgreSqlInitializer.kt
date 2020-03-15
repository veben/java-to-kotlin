package com.veben.microservices.order.ext.db.config

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import javax.validation.constraints.NotNull

internal class PostgreSqlInitializer : ApplicationContextInitializer<ConfigurableApplicationContext?> {
    private val postgresqlContainer: PostgreSQLContainer<*> = PostgreSQLContainer<Any?>("postgres:11.5-alpine")
    override fun initialize(configurableApplicationContext: @NotNull ConfigurableApplicationContext?) {
        postgresqlContainer
                .withDatabaseName("developer")
                .withUsername(configurableApplicationContext!!.environment.getProperty("spring.datasource.username"))
                .withPassword(configurableApplicationContext.environment.getProperty("spring.datasource.password"))
                .start()
        configurableApplicationContext.environment.systemProperties["spring.datasource.url"] = postgresqlContainer.getJdbcUrl()
    }
}