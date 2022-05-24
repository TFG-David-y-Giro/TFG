CREATE DATABASE IF NOT EXISTS Tfg;
USE tfg;
CREATE TABLE IF NOT EXISTS usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR (100) UNIQUE,
	nombre VARCHAR (100) NOT NULL,
	apellido VARCHAR (100) NOT NULL,
	correo VARCHAR (100) NOT NULL,
	contraseña VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS proveedor (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (100) NOT NULL,
	pais VARCHAR (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (100) NOT NULL,
	precio INT NOT NULL,
	categoria VARCHAR (100) NOT NULL,
	proveedor VARCHAR (100) NOT NULL,
	cantidad INT NOT NULL
);
CREATE TABLE IF NOT EXISTS cesta (
	id INT AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR (100) NOT NULL,
	precio_cesta INT NOT NULL
);
CREATE TABLE IF NOT EXISTS categoria (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (100) NOT NULL
);
INSERT INTO tfg.categoria (nombre)
VALUES ('Ordenadores sobremesa');

INSERT INTO tfg.categoria (nombre)
VALUES ('Ordenadores portatiles');

INSERT INTO tfg.categoria (nombre)
VALUES ('Procesadores');

INSERT INTO tfg.categoria (nombre)
VALUES ('Tarjetas graficas');

INSERT INTO tfg.categoria (nombre)
VALUES ('Memoria ram');

INSERT INTO tfg.categoria (nombre)
VALUES ('Memoria interna');

INSERT INTO tfg.categoria (nombre)
VALUES ('Refrigeraciones');

INSERT INTO tfg.categoria (nombre)
VALUES ('Fuentes de alimentacion');

INSERT INTO tfg.categoria (nombre)
VALUES ('Cables');

INSERT INTO tfg.categoria (nombre)
VALUES ('Chasis');

INSERT INTO tfg.cesta (usuario, precio_cesta)
VALUES ('Yiro', 2000);

INSERT INTO tfg.cesta (usuario, precio_cesta)
VALUES ('Deivid', 1500);

INSERT INTO tfg.cesta (usuario, precio_cesta)
VALUES ('SerLag', 499);

INSERT INTO tfg.cesta (usuario, precio_cesta)
VALUES ('MikSan', 399);

INSERT INTO tfg.item (nombre, precio, categoria, proveedor, cantidad)
VALUES ('MSI i5', 499, 'Ordenadores portatiles', 'PcComponentes', 1);

INSERT INTO tfg.item (nombre, precio, categoria, proveedor, cantidad)
VALUES ('Hummer i3', 399, 'Ordenadores sobremesa', 'PcBox', 1);

INSERT INTO tfg.item (nombre, precio, categoria, proveedor, cantidad)
VALUES ('RTX 3090', 2000, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.item (nombre, precio, categoria, proveedor, cantidad)
VALUES ('RTX 3080', 1500, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO tfg.proveedor (nombre, pais)
VALUES ('PcComponentes', 'España');

INSERT INTO tfg.proveedor (nombre, pais)
VALUES ('PcBox', 'España');

INSERT INTO tfg.proveedor (nombre, pais)
VALUES ('Nvidia', 'Estados Unidos');

INSERT INTO tfg.usuario (usuario, nombre, apellido, correo, contraseña)
VALUES ('Yiro', 'Miguel Angel', 'Girona', 'miguelangelgirona@gmail.com', 'Abcd1234');

INSERT INTO tfg.usuario (usuario, nombre, apellido, correo, contraseña)
VALUES ('Deivid', 'David', 'Pato', 'davidpato@gmail.com', 'Abcd1234');

INSERT INTO tfg.usuario (usuario, nombre, apellido, correo, contraseña)
VALUES ('SerLag', 'Sergio', 'Laguna', 'sergiolaguna@gmail.com', 'Abcd1234');

INSERT INTO tfg.usuario (usuario, nombre, apellido, correo, contraseña)
VALUES ('MikSan', 'Mikel', 'San Vicente', 'mikelsanvicente@gmail.com', 'Abcd1234');