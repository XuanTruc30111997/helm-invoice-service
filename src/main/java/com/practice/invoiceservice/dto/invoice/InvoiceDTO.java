package com.practice.invoiceservice.dto.invoice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceDTO {
    private String id;
    private String customerName;
    private Float totalPrice;
}
