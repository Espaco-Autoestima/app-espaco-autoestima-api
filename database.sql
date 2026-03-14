CREATE SCHEMA IF NOT EXISTS espacoautoestima;
USE espacoautoestima;

CREATE TABLE IF NOT EXISTS accounts(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50),
    phoneNumber VARCHAR(25),
    email VARCHAR(40),
    password VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS customers(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    phoneNumber VARCHAR(25),
    email VARCHAR(40),
    cpf VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS professionals(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    phoneNumber VARCHAR(25),
    speciality VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS procedures(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS schedule(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(30),
    professionalName VARCHAR(30),
    sessionQuantity BIGINT,
    dateSchedule date,
    hourSchedule time,
    customers_id BIGINT,
    professionals_id BIGINT,
    FOREIGN KEY (customers_id) REFERENCES customers(id),
    FOREIGN KEY (professionals_id) REFERENCES professionals(id)
);

CREATE TABLE IF NOT EXISTS disponibility(
    id_disponibility BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dayDisponibility date,
    hourDisponibility time,
    professionals_id BIGINT,
    FOREIGN KEY (professionals_id) REFERENCES professionals(id)
);

CREATE TABLE IF NOT EXISTS products(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    expirationDate date,
    quantity INT,
    brand VARCHAR(20),
    price decimal(10, 2),
    description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS suppliers(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    email VARCHAR(40),
    phoneNumber VARCHAR(20),
    companyName VARCHAR(20)
);