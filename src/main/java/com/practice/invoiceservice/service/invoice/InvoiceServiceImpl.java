package com.practice.invoiceservice.service.invoice;

import com.practice.invoiceservice.dto.invoice.InvoiceDTO;
import com.practice.invoiceservice.dto.invoice.InvoiceInsert;
import com.practice.invoiceservice.model.Invoice;
import com.practice.invoiceservice.repository.InvoiceRepository;
import com.practice.invoiceservice.utils.InvoiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public String insertInvoice(InvoiceInsert invoice) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("Ahihi_2 " + uuid);
        invoiceRepository.insertInvoice(uuid, invoice.getCustomerName());

        return uuid;
    }

    @Override
    public Collection<InvoiceDTO> getAllInvoice() {
        Collection<Invoice> invoices = invoiceRepository.getAllInvoice();
        return InvoiceUtils.mapInvoices(invoices);
    }

    @Override
    public InvoiceDTO getInvoiceById(String invoiceId) throws Exception {
        Collection<Invoice> invoices = invoiceRepository.getInvoiceById(invoiceId);
        if (!invoices.isEmpty()) {
            Optional<Invoice> invoiceOptional = invoices.stream().findFirst().filter(invoice -> Objects.equals(invoice.getId(), invoiceId));
            if (invoiceOptional.isPresent()) {
                return InvoiceUtils.mapInvoice(invoiceOptional.get());
            }
        }

        throw new Exception("Cannot find category");
    }
}
