package com.practice.invoiceservice.controller;

import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailInsert;
import com.practice.invoiceservice.dto.invoiceDetail.InvoiceDetailProduct;
import com.practice.invoiceservice.service.invoiceDetail.InvoiceDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice-detail")
@Slf4j
public class InvoiceDetailController {
    final String LOG_PREFIX = "InvoiceDetailController";
    @Autowired
    InvoiceDetailService invoiceDetailService;

    @PostMapping
    public ResponseEntity<String> addInvoiceDetail(@RequestBody InvoiceDetailInsert invoiceDetails) {
        log.info("Start adding invoice detail with {}", invoiceDetails.toString());
        String invoiceId = invoiceDetailService.insertInvoiceDetails(invoiceDetails);

        return ResponseEntity.ok().body(invoiceId);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDetailProduct> getInvoiceDetailByInvoiceId(@PathVariable("invoiceId") String invoiceId) {
        final String prefix = String.format("[%s.%s] ", LOG_PREFIX, "getInvoiceDetailByInvoiceId");
        log.info("{} start getting InvoiceDetails ", prefix);
        InvoiceDetailProduct invoiceDetailProduct = invoiceDetailService.getInvoiceDetailByInvoiceId(invoiceId);
        log.info("{} end getting InvoiceDetails ", prefix);
        return ResponseEntity.ok().body(invoiceDetailProduct);
    }
}
