package com.practice.invoiceservice.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_detail")
@Data
public class InvoiceDetail {
    @Id
    private String id;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;
}
