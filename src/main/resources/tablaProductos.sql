CREATE DATABASE NS7SQs2uYl;

USE NS7SQs2uYl;
DROP TABLE IF EXISTS productos;


CREATE TABLE productos(
idProd bigint auto_increment primary key,
titulo varchar(50),
descripcion varchar(150),
precio float,
descuento int
);
