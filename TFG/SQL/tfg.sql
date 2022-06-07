<<<<<<< HEAD
CREATE DATABASE IF NOT EXISTS PcShopMD;
USE PcShopMD;
CREATE TABLE IF NOT EXISTS user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR (100) UNIQUE,
	name VARCHAR (100) NOT NULL,
	surname VARCHAR (100) NOT NULL,
	mail VARCHAR (100) NOT NULL,
	password VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS supplier (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	country VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	price INT NOT NULL,
	category VARCHAR (100) NOT NULL,
	supplier VARCHAR (100) NOT NULL,
	cuantity INT NOT NULL
);
CREATE TABLE IF NOT EXISTS cart (
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR (100) NOT NULL,
	price INT NOT NULL
);
CREATE TABLE IF NOT EXISTS category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL
);
INSERT INTO tfg.category (name)
VALUES ('Ordenadores sobremesa');

INSERT INTO tfg.category (name)
VALUES ('Ordenadores portatiles');

INSERT INTO tfg.category (name)
VALUES ('Procesadores');

INSERT INTO tfg.category (name)
VALUES ('Tarjetas graficas');

INSERT INTO tfg.category (name)
VALUES ('Memoria ram');

INSERT INTO tfg.category (name)
VALUES ('Memoria interna');

INSERT INTO tfg.category (name)
VALUES ('Refrigeraciones');

INSERT INTO tfg.category (name)
VALUES ('Fuentes de alimentacion');

INSERT INTO tfg.category (name)
VALUES ('Cables');

INSERT INTO tfg.category (name)
VALUES ('Chasis');

INSERT INTO tfg.cart (user, price)
VALUES ('Yiro', 2000);

INSERT INTO tfg.cart (user, price)
VALUES ('Deivid', 1500);

INSERT INTO tfg.cart (user, price)
VALUES ('SerLag', 499);

INSERT INTO tfg.cart (user, price)
VALUES ('MikSan', 399);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('MSI i5', 499, 'Ordenadores portatiles', 'PcComponentes', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('Hummer i3', 399, 'Ordenadores sobremesa', 'PcBox', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('RTX 3090', 2000, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('RTX 3080', 1500, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.supplier (name, country)
VALUES ('PcComponentes', 'España');

INSERT INTO tfg.supplier (name, country)
VALUES ('PcBox', 'España');

INSERT INTO tfg.supplier (name, country)
VALUES ('Nvidia', 'Estados Unidos');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('Yiro', 'Miguel Angel', 'Girona', 'miguelangelgirona@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('Deivid', 'David', 'Pato', 'davidpato@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('SerLag', 'Sergio', 'Laguna', 'sergiolaguna@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
=======
CREATE DATABASE IF NOT EXISTS PcShopMD;
USE PcShopMD;
CREATE TABLE IF NOT EXISTS user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR (100) UNIQUE,
	name VARCHAR (100) NOT NULL,
	surname VARCHAR (100) NOT NULL,
	mail VARCHAR (100) NOT NULL,
	password VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS supplier (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	country VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL,
	price INT NOT NULL,
	category VARCHAR (100) NOT NULL,
	supplier VARCHAR (100) NOT NULL,
	cuantity INT NOT NULL
);
CREATE TABLE IF NOT EXISTS cart (
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR (100) NOT NULL,
	price INT NOT NULL
);
CREATE TABLE IF NOT EXISTS category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR (100) NOT NULL
);
INSERT INTO tfg.category (name)
VALUES ('Ordenadores sobremesa');

INSERT INTO tfg.category (name)
VALUES ('Ordenadores portatiles');

INSERT INTO tfg.category (name)
VALUES ('Procesadores');

INSERT INTO tfg.category (name)
VALUES ('Tarjetas graficas');

INSERT INTO tfg.category (name)
VALUES ('Memoria ram');

INSERT INTO tfg.category (name)
VALUES ('Memoria interna');

INSERT INTO tfg.category (name)
VALUES ('Refrigeraciones');

INSERT INTO tfg.category (name)
VALUES ('Fuentes de alimentacion');

INSERT INTO tfg.category (name)
VALUES ('Cables');

INSERT INTO tfg.category (name)
VALUES ('Chasis');

INSERT INTO tfg.cart (user, price)
VALUES ('Yiro', 2000);

INSERT INTO tfg.cart (user, price)
VALUES ('Deivid', 1500);

INSERT INTO tfg.cart (user, price)
VALUES ('SerLag', 499);

INSERT INTO tfg.cart (user, price)
VALUES ('MikSan', 399);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('MSI i5', 499, 'Ordenadores portatiles', 'PcComponentes', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('Hummer i3', 399, 'Ordenadores sobremesa', 'PcBox', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('RTX 3090', 2000, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.item (name, price, category, supplier, cuantity)
VALUES ('RTX 3080', 1500, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.supplier (name, country)
VALUES ('PcComponentes', 'España');

INSERT INTO tfg.supplier (name, country)
VALUES ('PcBox', 'España');

INSERT INTO tfg.supplier (name, country)
VALUES ('Nvidia', 'Estados Unidos');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('Yiro', 'Miguel Angel', 'Girona', 'miguelangelgirona@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('Deivid', 'David', 'Pato', 'davidpato@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
VALUES ('SerLag', 'Sergio', 'Laguna', 'sergiolaguna@gmail.com', 'Abcd1234');

INSERT INTO tfg.user (user, name, surname, mail, password)
>>>>>>> aee4f49db3dc8485964822d6d1aa7f68cf999834
VALUES ('MikSan', 'Mikel', 'San Vicente', 'mikelsanvicente@gmail.com', 'Abcd1234');