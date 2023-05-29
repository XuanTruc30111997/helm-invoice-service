package com.practice.invoiceservice.utils;

import com.practice.invoiceservice.dto.invoice.InvoiceDTO;
import com.practice.invoiceservice.model.Invoice;

import java.util.Collection;
import java.util.stream.Collectors;

public class InvoiceUtils {
    public static InvoiceDTO mapInvoice(Invoice invoice) {
        return InvoiceDTO.builder()
                .id(invoice.getId())
                .customerName(invoice.getCustomerName())
                .totalPrice(1234F)
                .build();
    }

    public static Collection<InvoiceDTO> mapInvoices(Collection<Invoice> invoices) {
        return invoices.stream().map(InvoiceUtils::mapInvoice).collect(Collectors.toList());
    }
}
