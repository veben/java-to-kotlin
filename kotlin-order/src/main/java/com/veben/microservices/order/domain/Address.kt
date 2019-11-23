package com.veben.microservices.order.domain

import javax.persistence.Embeddable

@Embeddable
class Address {
    var country: String? = null
    var city: String? = null
    var street: String? = null
    var number: Int? = null

    constructor()

    constructor(country: String?, city: String?, street: String?, number: Int?): this() {
        this.country = country
        this.city = city
        this.street = street
        this.number = number
    }
}
