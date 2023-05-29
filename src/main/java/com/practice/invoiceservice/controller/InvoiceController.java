package com.practice.invoiceservice.controller;

import com.practice.invoiceservice.dto.invoice.InvoiceDTO;
import com.practice.invoiceservice.dto.invoice.InvoiceInsert;
import com.practice.invoiceservice.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<String> addInvoice(@RequestBody InvoiceInsert invoice) {
        String invoiceId = invoiceService.insertInvoice(invoice);
        return ResponseEntity.ok().body(invoiceId);
    }

    @GetMapping
    public ResponseEntity<Collection<InvoiceDTO>> getInvoices() {
        Collection<InvoiceDTO> invoices = invoiceService.getAllInvoice();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getInvoiceByInvoiceId(@PathVariable("invoiceId") String invoiceId) {
        try {
            InvoiceDTO invoice = invoiceService.getInvoiceById(invoiceId);
            return ResponseEntity.ok(invoice);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
