package com.finflow.erp.service;

import com.finflow.erp.model.Invoice;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class UblXmlService {

    /**
     * Synthesizes standards-compliant UBL-TR 2.1 XML envelope for e-Invoice delivery
     */
    public String generateUblXml(Invoice invoice) {
        String dateStr = invoice.getIssueDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String timeStr = invoice.getIssueDate().format(DateTimeFormatter.ISO_LOCAL_TIME);

        return String.format("""
            <?xml version="1.0" encoding="UTF-8"?>
            <Invoice xmlns="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2"
                     xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2"
                     xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2">
                <cbc:UBLVersionID>2.1</cbc:UBLVersionID>
                <cbc:CustomizationID>TR1.2</cbc:CustomizationID>
                <cbc:ProfileID>TEMELFATURA</cbc:ProfileID>
                <cbc:ID>%s</cbc:ID>
                <cbc:UUID>%s</cbc:UUID>
                <cbc:IssueDate>%s</cbc:IssueDate>
                <cbc:IssueTime>%s</cbc:IssueTime>
                <cbc:InvoiceTypeCode>SATIS</cbc:InvoiceTypeCode>
                <cbc:DocumentCurrencyCode>TRY</cbc:DocumentCurrencyCode>
                <cac:AccountingSupplierParty>
                    <cac:Party>
                        <cac:PartyIdentification>
                            <cbc:ID schemeID="VKN">1234567890</cbc:ID>
                        </cac:PartyIdentification>
                    </cac:Party>
                </cac:AccountingSupplierParty>
                <cac:AccountingCustomerParty>
                    <cac:Party>
                        <cac:PartyIdentification>
                            <cbc:ID schemeID="VKN">%s</cbc:ID>
                        </cac:PartyIdentification>
                        <cac:PartyName>
                            <cbc:Name>%s</cbc:Name>
                        </cac:PartyName>
                    </cac:Party>
                </cac:AccountingCustomerParty>
                <cac:LegalMonetaryTotal>
                    <cbc:LineExtensionAmount currencyID="TRY">%.2f</cbc:LineExtensionAmount>
                    <cbc:TaxExclusiveAmount currencyID="TRY">%.2f</cbc:TaxExclusiveAmount>
                    <cbc:TaxInclusiveAmount currencyID="TRY">%.2f</cbc:TaxInclusiveAmount>
                    <cbc:PayableAmount currencyID="TRY">%.2f</cbc:PayableAmount>
                </cac:LegalMonetaryTotal>
            </Invoice>
            """,
            invoice.getInvoiceNumber(),
            invoice.getInvoiceUuid().toString(),
            dateStr,
            timeStr,
            invoice.getCustomerVkn(),
            invoice.getCustomerTitle(),
            invoice.getTotalTaxExclusive(),
            invoice.getTotalTaxExclusive(),
            invoice.getTotalPayable(),
            invoice.getTotalPayable()
        ).trim();
    }
}
