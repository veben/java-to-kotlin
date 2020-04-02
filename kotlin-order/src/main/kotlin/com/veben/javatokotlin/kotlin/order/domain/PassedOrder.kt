package com.veben.javatokotlin.kotlin.order.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "passed_order")
data class PassedOrder(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Embedded
    var buyer: Buyer? = null,
    var date: LocalDateTime? = null
) {
    constructor(buyer: Buyer, date: LocalDateTime) : this() {
        this.buyer = buyer
        this.date = date
    }
}
