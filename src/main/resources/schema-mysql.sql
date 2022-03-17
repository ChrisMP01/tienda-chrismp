DROP DATABASE IF EXISTS tiendaOnline  ;
CREATE DATABASE tiendaOnline ;
USE  tiendaOnline ;

CREATE TABLE usuario (
  id_usuario bigint NOT NULL AUTO_INCREMENT,
  nombre_usuario varchar(50) NOT NULL,
  apellido_usuario varchar(50) DEFAULT NULL,
  pass_usuario varchar(500) NOT NULL,
  email varchar(50) NOT NULL,
  fecha_nac varchar(10) NOT NULL,
  PRIMARY KEY (id_usuario)
) ;
CREATE TABLE SPRING_SESSION (
  PRIMARY_ID char(36) NOT NULL,
  SESSION_ID char(36) NOT NULL,
  CREATION_TIME bigint NOT NULL,
  LAST_ACCESS_TIME bigint NOT NULL,
  MAX_INACTIVE_INTERVAL int NOT NULL,
  EXPIRY_TIME bigint NOT NULL,
  PRINCIPAL_NAME varchar(100) DEFAULT NULL,
  PRIMARY KEY (PRIMARY_ID),
  UNIQUE KEY SPRING_SESSION_IX1 (SESSION_ID),
  KEY SPRING_SESSION_IX2 (EXPIRY_TIME),
  KEY SPRING_SESSION_IX3 (PRINCIPAL_NAME)
) ;

CREATE TABLE rol (
  id_rol bigint NOT NULL AUTO_INCREMENT,
  nombre_rol varchar(20) DEFAULT NULL,
  PRIMARY KEY (id_rol)
) ;


CREATE TABLE rol_user (
  id_usuario bigint NOT NULL,
  id_rol bigint NOT NULL,
  PRIMARY KEY (id_usuario,id_rol),
  KEY FKa4eqrxfjwbw2rrkl4xg0rcinl (id_rol),
  CONSTRAINT FKa4eqrxfjwbw2rrkl4xg0rcinl FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
  CONSTRAINT FKpjxlffe39mdwdn85791o7utp2 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ;



CREATE TABLE productos (
  id_prod bigint NOT NULL AUTO_INCREMENT,
  titulo varchar(50) DEFAULT NULL,
  descripcion varchar(150) DEFAULT NULL,
  precio float DEFAULT NULL,
  descuento int DEFAULT NULL,
  PRIMARY KEY (id_prod)
) ;

CREATE TABLE compra (
  id_compra bigint NOT NULL AUTO_INCREMENT,
  id_usuario bigint DEFAULT NULL,
  id_prod bigint DEFAULT NULL,
  precio float DEFAULT NULL,
  unidades int DEFAULT NULL,
  PRIMARY KEY (id_compra),

  CONSTRAINT compra_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT compra_ibfk_2 FOREIGN KEY (id_prod) REFERENCES productos (id_prod),
  CONSTRAINT compra_ibfk_3 FOREIGN KEY (id_prod) REFERENCES productos (id_prod),
  CONSTRAINT compra_ibfk_4 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT compra_ibfk_5 FOREIGN KEY (id_prod) REFERENCES productos (id_prod)
) ;

CREATE TABLE compra_producto(
	unidades float NOT NULL,
    id_prod bigint NOT NULL,
    id_compra bigint NOT NULL,
    PRIMARY KEY (id_prod,id_compra ),
	CONSTRAINT producto_compra FOREIGN KEY (id_prod) REFERENCES productos (id_prod),
	CONSTRAINT compra_producto FOREIGN KEY (id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE imagen(
	id_imagen bigint NOT NULL AUTO_INCREMENT,
    nombre_imagen varchar(50),
    imagen blob,
    id_producto bigint not null,
    PRIMARY KEY (id_imagen),
    CONSTRAINT fk_imagen_producto FOREIGN KEY (id_producto) REFERENCES productos (id_prod) ON UPDATE CASCADE
);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID char(36) NOT NULL,
  ATTRIBUTE_NAME varchar(200) NOT NULL,
  ATTRIBUTE_BYTES blob NOT NULL,
  PRIMARY KEY (SESSION_PRIMARY_ID,ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
) ;

