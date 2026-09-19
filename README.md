# FinFlow ERP — Finance & E-Invoice Processing System

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.3-green?style=flat-square&logo=springboot)
![MSSQL](https://img.shields.io/badge/Database-MSSQL_2022-CC292B?style=flat-square&logo=microsoftsqlserver)
![UBL XML](https://img.shields.io/badge/Format-UBL--TR_2.1-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-purple?style=flat-square)

FinFlow ERP is a financial ledger, e-Invoice (e-Fatura / e-Arşiv), and sub-ledger reconciliation engine built in Java and Spring Boot with Microsoft SQL Server. It parses, generates, and validates standardized UBL-TR 2.1 XML documents while keeping transactional debit/credit ledger records balanced with zero float divergence.

---

## 🏛️ Financial Architecture

```
       +-----------------------------------+
       |       ERP Billing Modules         |
       +-----------------+-----------------+
                         |
                         v
+--------------------------------------------------------------------+
|                   FinFlow Core Service Engine                      |
|                                                                    |
|  +---------------------------+       +--------------------------+  |
|  |   UBL-TR 2.1 Generator    | <---> |   XML Schema Validator   |  |
|  |   (JAXB / XML Stream)     |       |   (XSD & Schematron)     |  |
|  +-------------+-------------+       +--------------------------+  |
|                |                                                   |
|                v                                                   |
|  +---------------------------------------------------------------+ |
|  |               Sub-Ledger Reconciliation Worker                | |
|  |          (Double-Entry Bookkeeping: 120 / 391 / 600)          | |
|  +-------------------------------+-------------------------------+ |
+----------------------------------|---------------------------------+
                                   |
                                   v
                   +-------------------------------+
                   |     MSSQL 2022 Database       |
                   |   (Invoices & Ledger Tables)  |
                   +-------------------------------+
```

---

## 🚀 Key Features

- **UBL-TR 2.1 Compatibility**: Generates signed and schema-validated e-Invoice and e-Archive XML documents in compliance with statutory revenue administrations.
- **Double-Entry Reconciliation**: Automatically dispatches balanced general ledger postings upon invoice finalization.
- **Batch Processing**: High-performance multi-threaded invoice parser capable of indexing thousands of supplier invoices per minute.
- **MSSQL Enterprise Integration**: Native dialect mapping, transaction isolation, and column-store indexing.

---

## 🔌 API Reference

### Generate e-Invoice XML
```http
POST /api/v1/invoices/mock-generate?customerVkn=1234567890&customerTitle=TechCorp
```

**Response (Sample UBL XML Header):**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Invoice xmlns="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2">
    <cbc:UBLVersionID>2.1</cbc:UBLVersionID>
    <cbc:ProfileID>TEMELFATURA</cbc:ProfileID>
    <cbc:ID>GIB2026000000042</cbc:ID>
    <cbc:DocumentCurrencyCode>TRY</cbc:DocumentCurrencyCode>
    ...
</Invoice>
```

---

## 💻 Local Setup

```bash
git clone https://github.com/kubrvk/FinFlow-ERP.git
cd FinFlow-ERP

# Run MSSQL 2022 and Spring Boot backend
docker compose up -d --build
```

---

## 👤 Author & License

- **Author**: `kubrvk` ([GitHub Profile](https://github.com/kubrvk))
- **License**: MIT License.
