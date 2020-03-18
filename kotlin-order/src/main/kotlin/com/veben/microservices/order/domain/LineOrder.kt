package com.veben.microservices.order.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "line_order")
data class LineOrder(
    @Id
    val id: UUID = UUID.randomUUID(),
    var product: String? = null,
    var number: Int? = null,
    @ManyToOne
    var parentPassedOrder: PassedOrder? = null
)
