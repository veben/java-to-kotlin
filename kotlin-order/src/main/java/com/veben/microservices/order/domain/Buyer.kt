package com.veben.microservices.order.domain

import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.validation.constraints.Email

@Embeddable
class Buyer {

    @Email
    var email: String? = null
    var name: String? = null
    var surname: String? = null

    @Embedded
    var address: Address? = null

    constructor()

    constructor(email: String?, name: String?, surname: String?, address: Address?): this() {
        this.email = email
        this.name = name
        this.surname = surname
        this.address = address
    }
}
