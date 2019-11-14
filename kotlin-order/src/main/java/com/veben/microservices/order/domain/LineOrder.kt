package com.veben.microservices.order.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "line_order")
class LineOrder {

    @Id
    val id: UUID = UUID.randomUUID()

    private var product: String? = null
    private var number: Int? = null

    @ManyToOne
    var parentPassedOrder: PassedOrder? = null

    constructor()

    constructor(product: String, number: Int) : this() {
        this.product = product
        this.number = number
    }
}
