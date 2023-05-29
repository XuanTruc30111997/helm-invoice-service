package com.practice.invoiceservice.utils;

import com.practice.invoiceservice.dto.invoiceDetail.ProductQuantityDetail;
import com.practice.invoiceservice.model.InvoiceDetail;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceDetailsUtils {
    public static List<ProductQuantityDetail> buildProductQuantityDetails(List<InvoiceDetail> invoiceDetails) {
        return invoiceDetails.stream().map(invoiceDetail -> ProductQuantityDetail.builder()
                        .productId(invoiceDetail.getProductId())
                        .quantity(invoiceDetail.getQuantity())
                        .price(invoiceDetail.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
