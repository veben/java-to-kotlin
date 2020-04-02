package com.veben.javatokotlin.kotlin.order.ext

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8091")
                .select()
                .apis(basePackage("com.veben.javatokotlin.kotlin.order.ext.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "Kotlin Order",
                "Order management",
                "0.0.1",
                "https://github.com/veben/java-to-kotlin/blob/master/kotlin-order",
                Contact("Benoit Veyrière", "https://stackoverflow.com/users/8718377/veben", "benoit.veyriere@gmail.com"),
                "MIT License", "https://github.com/veben/java-to-kotlin/blob/master/LICENSE.md", emptyList())
    }
}
