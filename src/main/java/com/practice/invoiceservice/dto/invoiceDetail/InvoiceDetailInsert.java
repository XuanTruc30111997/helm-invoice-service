package com.practice.invoiceservice.dto.invoiceDetail;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceDetailInsert {
    private String invoiceId;
    private List<ProductQuantityDetail> productQuantityDetail;
}
