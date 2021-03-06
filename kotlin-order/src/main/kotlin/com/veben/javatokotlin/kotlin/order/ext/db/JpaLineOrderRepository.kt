package com.veben.javatokotlin.kotlin.order.ext.db

import com.veben.javatokotlin.kotlin.order.domain.LineOrder
import com.veben.javatokotlin.kotlin.order.domain.LineOrderRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class JpaLineOrderRepository : LineOrderRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findLineOrdersForOrder(parentOrderId: String): List<LineOrder> {
        val query = "select l from LineOrder l where l.parentPassedOrder.id = :parentOrderId"

        return ArrayList(entityManager.createQuery(query, LineOrder::class.java)
                .setParameter("parentOrderId", UUID.fromString(parentOrderId))
                .resultList)
    }
}
