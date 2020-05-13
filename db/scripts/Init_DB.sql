CREATE TYPE customer_type AS ENUM('INDIVIDUAL', 'ORGANIZATION');
CREATE TYPE operation_type AS ENUM('CREDIT', 'DEBIT');
CREATE TYPE account_type AS ENUM('CORPORATE', 'STRICT', 'COMMON', 'LIGHT', 'RELIABLE');

CREATE TABLE departments (
	department_id SERIAL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	address VARCHAR(256) NOT NULL
);

CREATE TABLE accounts (
	account_id SERIAL PRIMARY KEY,
	"number" VARCHAR(10) NOT NULL,
	customer_id INTEGER,
	balance REAL NOT NULL,
	type_id INTEGER,
	interest_account INTEGER,
	department_id INTEGER,
	date_of_start TIMESTAMP NOT NULL
);

CREATE TABLE operations (
	operation_id SERIAL PRIMARY KEY,
	account_id INTEGER,
	operation operation_type NOT NULL,
	amount REAL NOT NULL,
	"date" TIMESTAMP NOT NULL
);

CREATE TABLE types_of_account (
	type_id SERIAL PRIMARY KEY,
	name account_type NOT NULL,
	yield REAL NOT NULL,
	interval INTEGER NOT NULL,
	max_credit INTEGER NOT NULL,
	max_debit INTEGER NOT NULL
);

CREATE TABLE customers (
	customer_id SERIAL PRIMARY KEY,
	type customer_type NOT NULL DEFAULT 'INDIVIDUAL',
	name VARCHAR(64) NOT NULL,
	date_of_registration TIMESTAMP NOT NULL
);

CREATE TABLE contacts (
	contact_id SERIAL NOT NULL,
	customer_id INTEGER,
	name VARCHAR(32) NOT NULL,
	surname VARCHAR(32) NOT NULL,
	address VARCHAR(256) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	"email" VARCHAR(64) NOT NULL
);

ALTER TABLE contacts
	ADD FOREIGN KEY (customer_id) REFERENCES customers ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE operations 
	ADD FOREIGN KEY (account_id) REFERENCES accounts ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE accounts 
	ADD FOREIGN KEY (customer_id) REFERENCES customers ON DELETE CASCADE ON UPDATE CASCADE,
	ADD FOREIGN KEY (type_id) REFERENCES types_of_account ON DELETE CASCADE ON UPDATE CASCADE,
	ADD FOREIGN KEY (department_id) REFERENCES departments ON DELETE CASCADE ON UPDATE CASCADE,
	ADD FOREIGN KEY (interest_account) REFERENCES accounts (account_id) ON DELETE CASCADE ON UPDATE CASCADE;