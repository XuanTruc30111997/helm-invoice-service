package com.practice.invoiceservice.dto.invoiceDetail;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InvoiceDetailProduct {
    private String invoiceId;
    private String customerName;
    private List<ProductQuantityDetail> productQuantityDetails;
}
