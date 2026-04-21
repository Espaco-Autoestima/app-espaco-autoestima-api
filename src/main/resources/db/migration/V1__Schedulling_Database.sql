CREATE SCHEMA IF NOT EXISTS espacoautoestima;
USE espacoautoestima;

CREATE TABLE IF NOT EXISTS accounts(
    accounts_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50),
    phoneNumber VARCHAR(25),
    email VARCHAR(40),
    password VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS customers(
    customers_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    phoneNumber VARCHAR(25),
    email VARCHAR(40),
    cpf VARCHAR(14)
);

CREATE TABLE IF NOT EXISTS professionals(
    professionals_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    phoneNumber VARCHAR(25),
    email VARCHAR(40),
    speciality VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS procedures(
    procedures_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS schedules(
    schedule_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(45),
    professionalName VARCHAR(45),
    sessionQuantity BIGINT,
    dateSchedule date,
    hourSchedule time,
    customers_id BIGINT,
    professionals_id BIGINT,
    FOREIGN KEY (customers_id) REFERENCES customers(customers_id),
    FOREIGN KEY (professionals_id) REFERENCES professionals(professionals_id)
);

CREATE TABLE IF NOT EXISTS disponibility(
    disponibility_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dayDisponibility date,
    hourStart time,
    hourEnd time,
    professionals_id BIGINT,
    FOREIGN KEY (professionals_id) REFERENCES professionals(professionals_id)
);

CREATE TABLE IF NOT EXISTS products(
    products_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    expirationDate date,
    quantity INT,
    brand VARCHAR(20),
    price decimal(10, 2),
    description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS suppliers(
    suppliers_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    email VARCHAR(40),
    phoneNumber VARCHAR(20),
    companyName VARCHAR(20)
);