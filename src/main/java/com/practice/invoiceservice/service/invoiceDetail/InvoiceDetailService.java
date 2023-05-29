package com.practice.invoiceservice.service.invoiceDetail;

import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailInsert;
import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailProduct;
import com.practice.invoiceservice.dto.invoiceDetail.ProductQuantityDetail;

public interface InvoiceDetailService {
    String insertInvoiceDetail(String invoiceId, ProductQuantityDetail productQuantityDetail);
    String insertInvoiceDetails(InvoiceDetailInsert invoiceDetails);
    InvoiceDetailProduct getInvoiceDetailByInvoiceId(String invoiceId);
}
