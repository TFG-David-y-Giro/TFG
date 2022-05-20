CREATE DATABASE IF NOT EXISTS Tfg;

USE Tfg;

CREATE TABLE IF NOT EXISTS User (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR (100) UNIQUE,
	name VARCHAR (100) NOT NULL,
	surname VARCHAR (100) NOT NULL,
	mail VARCHAR (100) NOT NULL,
	password VARCHAR (100) NOT NULL,
	admin BIT NOT NULL
);

CREATE TABLE IF NOT EXISTS Supplier (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	city VARCHAR (100) NOT NULL,
	item VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	price INT NOT NULL,
	category VARCHAR (100) NOT NULL,
	supplier VARCHAR (100) NOT NULL,
	quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Basket (
	id INT AUTO_INCREMENT PRIMARY KEY,
	token username VARCHAR (100) NOT NULL,
	username VARCHAR (100) NOT NULL,
	item VARCHAR (100) NOT NULL,
	item_price INT NOT NULL,
	cuantity INT NOT NULL,
	basket_price INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL
);