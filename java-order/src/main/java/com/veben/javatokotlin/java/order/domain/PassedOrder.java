package com.veben.javatokotlin.java.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.NONE;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "passed_order")
public class PassedOrder {

    @Id
    @Setter(NONE)
    private UUID id;

    @Embedded
    private Buyer buyer;

    LocalDateTime date;

    protected PassedOrder() {
        this.id = UUID.randomUUID();
    }

    public PassedOrder(Buyer buyer, LocalDateTime date) {
        this();
        this.buyer = buyer;
        this.date = date;
    }
}
