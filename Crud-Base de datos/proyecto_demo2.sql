CREATE DATABASE PROYECTO_DEMODOS;

CREATE TABLE PRODUCTOS(
    id_producto             INT             PRIMARY KEY AUTO_INCREMENT,
    nombre_producto         VARCHAR(50)     NOT NULL,
    precio_compra           FLOAT           NOT NULL,
    existencias_producto    INT             NULL DEFAULT 0,
    marca_producto          VARCHAR(50)     NULL DEFAULT "Generico");