# FinFlow-ERP

<img align="left" width="40%" src="https://raw.githubusercontent.com/kubrvk/portfolio/main/img/galeri/site/9a.jpg"/>

<h3><a href="https://github.com/kubrvk/FinFlow-ERP"><img src="https://img.shields.io/badge/GitHub-kubrvk%2FFinFlow-ERP-000000?style=flat-square&logo=github&logoColor=white" height="25"/></a></h3>

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badges&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badges&logo=springboot&logoColor=white) ![MSSQL](https://img.shields.io/badge/Microsoft_SQL_Server-CC292B?style=for-the-badges&logo=microsoftsqlserver&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badges&logo=hibernate&logoColor=white)

<br>

Enterprise financial accounting ledger and regulatory UBL XML e-invoice parsing and validation engine.

<br clear="left"/>

---

## Technical Details

| Component | Specification |
|---|---|
| Backend Framework | Java 17, Spring Boot 3.x |
| ORM & Persistence | Hibernate / JPA (High-throughput Batch Queries) |
| Database | Microsoft SQL Server (MSSQL Ledger & Stored Procedures) |
| E-Invoice Standard | UBL 2.1 XML Parsing, XSD Schema Validation & Schematron |
| API Architecture | RESTful Web Services for ERP Reconciliation |

---

## Code Overview & Architecture

```text
FinFlow-ERP/
├── src/main/java/com/finflow/
│   ├── config/            # Database & XML Parser configuration
│   ├── controllers/       # Invoice submission & accounting reports
│   ├── models/            # General ledger, invoice & tax entities
│   ├── parser/            # UBL 2.1 XML parser & schema validator
│   ├── repository/        # MSSQL database repositories
│   └── service/           # Balance matching & financial settlement
├── src/main/resources/
│   ├── schemas/           # UBL XML XSD schema definition files
│   └── application.yml
├── pom.xml
└── README.md
```

---

## License & Author

Developed by **[Beraat Yetkin](https://github.com/kubrvk)**. All rights reserved.
