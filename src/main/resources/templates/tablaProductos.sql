DROP DATABASE IF EXISTS NS7SQs2uYl;
CREATE DATABASE NS7SQs2uYl;

USE NS7SQs2uYl;
DROP TABLE IF EXISTS productos;
USE tiendaOnline;

CREATE TABLE productos(
id_prod bigint auto_increment primary key,
titulo varchar(50),
descripcion varchar(150),
precio float,
descuento int
);

insert into productos(id_prod,titulo,descripcion,precio,descuento) values(1,"pan integral","pan con trigo integrado.",12.50,5);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(2,"pan normal","pan común, el de toda la vida.",20.10,4);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(3,"pan cuadrado","pan con forma cuadrada.",21.30,3);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(4,"pan triangular","pan triangular.",23.25,2);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(5,"panceta","pan con panceta integrada.",43.95,1);