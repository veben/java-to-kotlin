package com.veben.microservices.order.ext

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import springfox.documentation.builders.RequestHandlerSelectors.basePackage

@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8091")
                .select()
                .apis(basePackage("com.veben.microservices.order.ext.rest"))
                .paths(PathSelectors.any())
                .build()
    }
}
