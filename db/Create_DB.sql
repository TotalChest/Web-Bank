DROP TYPE IF EXISTS customer_type, operation_type, account_type CASCADE;
DROP TABLE IF EXISTS departments, accounts, operations, types_of_account, customers, contacts CASCADE;

CREATE TYPE customer_type AS ENUM('individual', 'organization');
CREATE TYPE operation_type AS ENUM('credit', 'debit');
CREATE TYPE account_type AS ENUM('corporate', 'strict', 'common', 'light', 'reliable');

CREATE TABLE departments (
	department_id SERIAL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	adress VARCHAR(256) NOT NULL
);

CREATE TABLE accounts (
	account_id SERIAL PRIMARY KEY,
	"number" VARCHAR(10) NOT NULL,
	customer_id INTEGER NOT NULL,
	balance REAL NOT NULL,
	type_id INTEGER NOT NULL,
	interest_account INTEGER NOT NULL,
	department_id INTEGER NOT NULL,
	date_of_start TIMESTAMP NOT NULL
);

CREATE TABLE operations (
	operation_id SERIAL PRIMARY KEY,
	account_id INTEGER NOT NULL,
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
	type customer_type NOT NULL DEFAULT 'individual',
	name VARCHAR(64) NOT NULL,
	date_of_registration TIMESTAMP NOT NULL
);

CREATE TABLE contacts (
	contact_id SERIAL NOT NULL,
	customer_id INTEGER NOT NULL,
	name VARCHAR(32) NOT NULL,
	surname VARCHAR(32) NOT NULL,
	adress VARCHAR(256) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	"e-mail" VARCHAR(64) NOT NULL
);

ALTER TABLE contacts
	ADD FOREIGN KEY (customer_id) REFERENCES customers ON DELETE CASCADE;

ALTER TABLE operations 
	ADD FOREIGN KEY (account_id) REFERENCES accounts ON DELETE CASCADE;

ALTER TABLE accounts 
	ADD FOREIGN KEY (customer_id) REFERENCES customers ON DELETE CASCADE,
	ADD FOREIGN KEY (type_id) REFERENCES types_of_account ON DELETE CASCADE,
	ADD FOREIGN KEY (department_id) REFERENCES departments ON DELETE CASCADE,
	ADD FOREIGN KEY (interest_account) REFERENCES accounts (account_id) ON DELETE CASCADE;