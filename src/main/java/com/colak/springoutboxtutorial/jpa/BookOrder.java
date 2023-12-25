package com.colak.springoutboxtutorial.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer_order")
public class BookOrder {

    @Id
    @Column(name = "order_id")
    int orderId;

    @Column(name = "customer_id")
    int customerId;
}
