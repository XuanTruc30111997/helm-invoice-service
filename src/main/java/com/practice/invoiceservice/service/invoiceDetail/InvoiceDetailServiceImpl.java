package com.practice.invoiceservice.service.invoiceDetail;

import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailInsert;
import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailProduct;
import com.practice.invoiceservice.dto.invoiceDetail.ProductQuantityDetail;
import com.practice.invoiceservice.model.Invoice;
import com.practice.invoiceservice.model.InvoiceDetail;
import com.practice.invoiceservice.repository.InvoiceDetailRepository;
import com.practice.invoiceservice.repository.InvoiceRepository;
import com.practice.invoiceservice.utils.InvoiceDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public String insertInvoiceDetail(String invoiceId, ProductQuantityDetail productQuantityDetail) {
        String uuid = UUID.randomUUID().toString();
        invoiceDetailRepository.insertInvoice(uuid, invoiceId, productQuantityDetail.getProductId(), productQuantityDetail.getQuantity(), productQuantityDetail.getPrice());

        return uuid;
    }

    @Override
    public String insertInvoiceDetails(InvoiceDetailInsert invoiceDetails) {
        String invoiceId = invoiceDetails.getInvoiceId();
        invoiceDetails.getProductQuantityDetail().forEach(invoiceDetail -> insertInvoiceDetail(invoiceId, invoiceDetail));

        return invoiceId;
    }

    @Override
    public InvoiceDetailProduct getInvoiceDetailByInvoiceId(String invoiceId) {
        Collection<Invoice> invoices = invoiceRepository.getInvoiceById(invoiceId);
        if (!invoices.isEmpty()) {
            Optional<Invoice> invoiceOptional = invoices.stream().findFirst().filter(invoice -> Objects.equals(invoice.getId(), invoiceId));
            if (invoiceOptional.isPresent()) {
                Invoice invoice = invoiceOptional.get();
                 Collection<InvoiceDetail> invoiceDetails = invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoiceId);

                 return InvoiceDetailProduct.builder()
                         .invoiceId(invoiceId)
                         .customerName(invoice.getCustomerName())
                         .productQuantityDetails(InvoiceDetailsUtils.buildProductQuantityDetails(List.copyOf(invoiceDetails)))
                         .build();
            }
        }
        return null;
    }
}
