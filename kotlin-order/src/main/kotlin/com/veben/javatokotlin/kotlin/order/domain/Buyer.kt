package com.veben.javatokotlin.kotlin.order.domain

import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.validation.constraints.Email

@Embeddable
data class Buyer(
    @Email
    var email: String? = null,
    var name: String? = null,
    var surname: String? = null,
    @Embedded
    var address: Address? = null
)