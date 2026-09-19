package com.finflow.erp.controller;

import com.finflow.erp.model.Invoice;
import com.finflow.erp.service.UblXmlService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    private final UblXmlService ublXmlService;

    public InvoiceController(UblXmlService ublXmlService) {
        this.ublXmlService = ublXmlService;
    }

    @PostMapping("/mock-generate")
    public ResponseEntity<Invoice> generateMockInvoice(@RequestParam String customerVkn, @RequestParam String customerTitle) {
        Invoice invoice = Invoice.builder()
                .invoiceUuid(UUID.randomUUID())
                .invoiceNumber("GIB2026000000042")
                .issueDate(LocalDateTime.now())
                .customerVkn(customerVkn)
                .customerTitle(customerTitle)
                .totalTaxExclusive(BigDecimal.valueOf(10000.00))
                .totalTaxAmount(BigDecimal.valueOf(2000.00))
                .totalPayable(BigDecimal.valueOf(12000.00))
                .status(Invoice.InvoiceStatus.GENERATED)
                .build();

        String xml = ublXmlService.generateUblXml(invoice);
        invoice.setUblXmlContent(xml);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping(value = "/sample-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getSampleXml() {
        Invoice inv = Invoice.builder()
                .invoiceUuid(UUID.fromString("12345678-1234-1234-1234-123456789abc"))
                .invoiceNumber("GIB2026000000001")
                .issueDate(LocalDateTime.now())
                .customerVkn("9876543210")
                .customerTitle("Acme Holding A.S.")
                .totalTaxExclusive(BigDecimal.valueOf(50000.00))
                .totalTaxAmount(BigDecimal.valueOf(10000.00))
                .totalPayable(BigDecimal.valueOf(60000.00))
                .build();

        return ResponseEntity.ok(ublXmlService.generateUblXml(inv));
    }
}
