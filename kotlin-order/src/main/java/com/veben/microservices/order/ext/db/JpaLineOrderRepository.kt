package com.veben.microservices.order.ext.db

import com.veben.microservices.order.domain.LineOrder
import com.veben.microservices.order.domain.LineOrderRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
open class JpaLineOrderRepository : LineOrderRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findLineOrdersForOrder(parentOrderId: String): List<LineOrder> {
        val query = "select l from LineOrder l where l.parentPassedOrder.id = :parentOrderId"

        return ArrayList(entityManager.createQuery(query, LineOrder::class.java)
                .setParameter("parentOrderId", UUID.fromString(parentOrderId))
                .resultList)
    }
}
