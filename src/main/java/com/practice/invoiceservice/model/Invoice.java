package com.practice.invoiceservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
@Data
public class Invoice {
    @Id
    private String id;
    @Column(name = "customer_name")
    private String customerName;
}
