package com.veben.microservices.order.domain

import javax.persistence.Embeddable

@Embeddable
data class Address(
    var country: String? = null,
    var city: String? = null,
    var street: String? = null,
    var number: Int? = null
)
