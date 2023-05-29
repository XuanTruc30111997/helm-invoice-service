package com.practice.invoiceservice.service.invoice;

import com.practice.invoiceservice.dto.invoice.InvoiceDTO;
import com.practice.invoiceservice.dto.invoice.InvoiceInsert;

import java.util.Collection;

public interface InvoiceService {
    String insertInvoice(InvoiceInsert invoice);
    Collection<InvoiceDTO> getAllInvoice();
    InvoiceDTO getInvoiceById(String invoiceId) throws Exception;
}
