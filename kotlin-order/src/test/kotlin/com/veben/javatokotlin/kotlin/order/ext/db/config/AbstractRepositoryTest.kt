package com.veben.javatokotlin.kotlin.order.ext.db.config

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@ComponentScan(basePackages = ["com.veben.javatokotlin.kotlin.order.ext.db"])
@ContextConfiguration(initializers = [PostgreSqlInitializer::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = ["/data/data-local.sql"])
@ActiveProfiles("local")
@Testcontainers(disabledWithoutDocker = true)
abstract class AbstractRepositoryTest
