package com.practice.invoiceservice.dto.invoiceDetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductQuantityDetail {
    private String productId;
    private int quantity;
    private float price;
}
