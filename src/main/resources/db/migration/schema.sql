-- Schema DDL for FinFlow ERP
CREATE TABLE invoices (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    invoice_uuid UNIQUEIDENTIFIER NOT NULL UNIQUE,
    invoice_number VARCHAR(16) NOT NULL UNIQUE,
    issue_date DATETIME2 NOT NULL,
    customer_vkn VARCHAR(11) NOT NULL,
    customer_title NVARCHAR(255) NOT NULL,
    total_tax_exclusive DECIMAL(18,2) NOT NULL,
    total_tax_amount DECIMAL(18,2) NOT NULL,
    total_payable DECIMAL(18,2) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'DRAFT',
    ubl_xml_content NVARCHAR(MAX)
);

CREATE TABLE invoice_items (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    invoice_id BIGINT FOREIGN KEY REFERENCES invoices(id) ON DELETE CASCADE,
    item_description NVARCHAR(200) NOT NULL,
    quantity DECIMAL(12,3) NOT NULL,
    unit_price DECIMAL(18,4) NOT NULL,
    tax_percent DECIMAL(5,2) NOT NULL,
    line_total DECIMAL(18,2) NOT NULL
);

CREATE TABLE ledger_entries (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    account_code VARCHAR(30) NOT NULL,
    debit_amount DECIMAL(18,2) NOT NULL DEFAULT 0.00,
    credit_amount DECIMAL(18,2) NOT NULL DEFAULT 0.00,
    transaction_date DATETIME2 NOT NULL,
    reference_invoice_id BIGINT FOREIGN KEY REFERENCES invoices(id)
);
