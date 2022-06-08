CREATE DATABASE IF NOT EXISTS PcShopMD;
USE PcShopMD;
CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR (100) UNIQUE,
  name VARCHAR (100) NOT NULL,
  surname VARCHAR (100) NOT NULL,
  mail VARCHAR (100) NOT NULL,
  password VARCHAR (100) NOT NULL,
  INDEX (id)
);

INSERT INTO PcShopMD.user (username, name, surname, mail, password)
VALUES ('Yiro', 'Miguel Angel', 'Girona', 'miguelangelgirona@gmail.com', 'Abcd1234');

INSERT INTO PcShopMD.user (username, name, surname, mail, password)
VALUES ('Deivid', 'David', 'Pato', 'davidpato@gmail.com', 'Abcd1234');

INSERT INTO PcShopMD.user (username, name, surname, mail, password)
VALUES ('SerLag', 'Sergio', 'Laguna', 'sergiolaguna@gmail.com', 'Abcd1234');

INSERT INTO PcShopMD.user (username, name, surname, mail, password)
VALUES ('MikSan', 'Mikel', 'San Vicente', 'mikelsanvicente@gmail.com', 'Abcd1234');

CREATE TABLE IF NOT EXISTS category (
  id INT AUTO_INCREMENT,
  name VARCHAR (100) UNIQUE,
  PRIMARY KEY (id, name),
  INDEX (id)
);
INSERT INTO PcShopMD.category (name)
VALUES ('Ordenadores sobremesa');

INSERT INTO PcShopMD.category (name)
VALUES ('Ordenadores portatiles');

INSERT INTO PcShopMD.category (name)
VALUES ('Procesadores');

INSERT INTO PcShopMD.category (name)
VALUES ('Tarjetas graficas');

INSERT INTO PcShopMD.category (name)
VALUES ('Memoria ram');

INSERT INTO PcShopMD.category (name)
VALUES ('Memoria interna');

INSERT INTO PcShopMD.category (name)
VALUES ('Refrigeraciones');

INSERT INTO PcShopMD.category (name)
VALUES ('Fuentes de alimentacion');

INSERT INTO PcShopMD.category (name)
VALUES ('Cables');

INSERT INTO PcShopMD.category (name)
VALUES ('Chasis');

CREATE TABLE IF NOT EXISTS supplier (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) UNIQUE,
  country VARCHAR (100) NOT NULL,
  INDEX (id)
);

INSERT INTO PcShopMD.supplier (name, country)
VALUES ('PcComponentes', 'EspaÃ±a');

INSERT INTO PcShopMD.supplier (name, country)
VALUES ('PcBox', 'EspaÃ±a');

INSERT INTO PcShopMD.supplier (name, country)
VALUES ('Nvidia', 'Estados Unidos');

CREATE TABLE IF NOT EXISTS item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) NOT NULL,
  price INT NOT NULL,
  category VARCHAR (100) NOT NULL,
  supplier VARCHAR (100) NOT NULL,
  quantity INT NOT NULL,
  INDEX (id),
  CONSTRAINT FK_item_supplier FOREIGN KEY (supplier) REFERENCES supplier (name) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FK_item_category FOREIGN KEY (category) REFERENCES category (name) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO PcShopMD.item (name, price, category, supplier, quantity)
VALUES ('MSI i5', 499, 'Ordenadores portatiles', 'PcComponentes', 1);

INSERT INTO PcShopMD.item (name, price, category, supplier, quantity)
VALUES ('Hummer i3', 399, 'Ordenadores sobremesa', 'PcBox', 1);

INSERT INTO PcShopMD.item (name, price, category, supplier, quantity)
VALUES ('RTX 3090', 2000, 'Tarjetas graficas', 'Nvidia', 1);

INSERT INTO PcShopMD.item (name, price, category, supplier, quantity)
VALUES ('RTX 3080', 1500, 'Tarjetas graficas', 'Nvidia', 1);

CREATE TABLE IF NOT EXISTS cart (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user VARCHAR (100) NOT NULL,
  price INT NOT NULL,
  INDEX (id),
  CONSTRAINT FK_cart_user FOREIGN KEY (user) REFERENCES user (username) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO PcShopMD.cart (user, price)
VALUES ('Yiro', 2000);

INSERT INTO PcShopMD.cart (user, price)
VALUES ('Deivid', 1500);

INSERT INTO PcShopMD.cart (user, price)
VALUES ('SerLag', 499);

INSERT INTO PcShopMD.cart (user, price)
VALUES ('MikSan', 399);
