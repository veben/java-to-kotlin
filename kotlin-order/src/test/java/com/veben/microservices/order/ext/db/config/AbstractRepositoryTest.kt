package com.veben.microservices.order.ext.db

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.testcontainers.containers.PostgreSQLContainer
import javax.validation.constraints.NotNull

@DataJpaTest
@ComponentScan(basePackages = ["com.veben.microservices.order.ext.db"])
@Sql(scripts = ["/data/data-local.sql"])
@ActiveProfiles("local")
@ContextConfiguration(initializers = [AbstractRepositoryTest.Initializer::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class AbstractRepositoryTest {

    class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

        companion object {
            internal val postgresqlContainer = PostgreSQLContainer<Nothing>("postgres:12-alpine")
        }

        override fun initialize(@NotNull configurableApplicationContext: ConfigurableApplicationContext) {
                postgresqlContainer
                        .apply {
                            withDatabaseName("order")
                            withUsername(configurableApplicationContext.environment.getProperty("spring.datasource.username"))
                            withPassword(configurableApplicationContext.environment.getProperty("spring.datasource.password"))
                        }.start()
                configurableApplicationContext.environment.systemProperties["spring.datasource.url"] = postgresqlContainer.jdbcUrl
        }
    }
}
