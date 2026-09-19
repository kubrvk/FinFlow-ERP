package com.finflow.erp.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID invoiceUuid;

    @Column(nullable = false, unique = true, length = 16)
    private String invoiceNumber;

    @Column(nullable = false)
    private LocalDateTime issueDate;

    @Column(nullable = false, length = 11)
    private String customerVkn;

    @Column(nullable = false)
    private String customerTitle;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal totalTaxExclusive;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal totalTaxAmount;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal totalPayable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private InvoiceStatus status;

    @Lob
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String ublXmlContent;

    @PrePersist
    protected void onCreate() {
        if (this.invoiceUuid == null) this.invoiceUuid = UUID.randomUUID();
        if (this.status == null) this.status = InvoiceStatus.DRAFT;
    }

    public enum InvoiceStatus {
        DRAFT, GENERATED, SIGNED, SUBMITTED_TO_GIB, APPROVED, REJECTED
    }
}
