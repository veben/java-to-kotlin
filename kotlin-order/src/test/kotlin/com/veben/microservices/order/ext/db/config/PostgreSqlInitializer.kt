package com.veben.microservices.order.ext.db.config

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer

internal class PostgreSqlInitializer : ApplicationContextInitializer<ConfigurableApplicationContext?> {

    companion object {
        private const val POSTGRES_IMAGE = "postgres:11.5-alpine"
        private const val DATABASE = "order"
        private const val USERNAME_PROPERTY = "spring.datasource.username"
        private const val PASSWD_PROPERTY = "spring.datasource.password"
        private const val URL_PROPERTY = "spring.datasource.url"

        private val postgresqlContainer = PostgreSQLContainer<Nothing>(POSTGRES_IMAGE)
    }

    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext?) {
        postgresqlContainer
                .apply {
                    withDatabaseName(DATABASE)
                    withUsername(configurableApplicationContext?.environment?.getProperty(USERNAME_PROPERTY))
                    withPassword(configurableApplicationContext?.environment?.getProperty(PASSWD_PROPERTY))
                }.start()

        configurableApplicationContext?.environment?.systemProperties?.set(URL_PROPERTY, postgresqlContainer.jdbcUrl)
    }
}