DROP TABLE IF EXISTS rol_user;
DROP TABLE IF EXISTS compra_producto;
DROP TABLE IF EXISTS compra;
DROP TABLE IF EXISTS imagen;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS SPRING_SESSION;
DROP TABLE IF EXISTS SPRING_SESSION_ATTRIBUTES;


CREATE TABLE usuario (
  id_usuario SERIAL PRIMARY KEY,
  nombre_usuario TEXT NOT NULL,
  apellido_usuario TEXT DEFAULT NULL,
  pass_usuario TEXT NOT NULL,
  email TEXT NOT NULL,
  fecha_nac TEXT NOT NULL
) ;


CREATE TABLE rol (
  id_rol SERIAL PRIMARY KEY,
  nombre_rol TEXT DEFAULT NULL
) ;


CREATE TABLE rol_user (
  id_usuario INT NOT NULL,
  id_rol INT NOT NULL,
  PRIMARY KEY (id_usuario,id_rol),
  CONSTRAINT FKa4eqrxfjwbw2rrkl4xg0rcinl FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
  CONSTRAINT FKpjxlffe39mdwdn85791o7utp2 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ;
CREATE INDEX FKa4eqrxfjwbw2rrkl4xg0rcinl ON rol (id_rol);


CREATE TABLE productos (
  id_prod SERIAL PRIMARY KEY,
  titulo TEXT DEFAULT NULL,
  descripcion TEXT DEFAULT NULL,
  precio float DEFAULT NULL,
  descuento int DEFAULT NULL
) ;

CREATE TABLE compra (
  id_compra SERIAL PRIMARY KEY,
  id_usuario bigint DEFAULT NULL,
  id_prod bigint DEFAULT NULL,
  precio float DEFAULT NULL,
  unidades INT DEFAULT NULL,

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
    PRIMARY KEY (id_prod,id_compra),
	CONSTRAINT producto_compra FOREIGN KEY (id_prod) REFERENCES productos (id_prod),
	CONSTRAINT compra_producto FOREIGN KEY (id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE imagen(
	id_imagen SERIAL PRIMARY KEY,
    nombre_imagen TEXT,
    imagen bytea,
    id_producto bigint not null,
    CONSTRAINT fk_imagen_producto FOREIGN KEY (id_producto) REFERENCES productos (id_prod) ON UPDATE CASCADE
);


/*CREATE TABLE SPRING_SESSION (
  PRIMARY_ID SERIAL PRIMARY KEY,
  SESSION_ID TEXT NOT NULL,
  CREATION_TIME INT NOT NULL,
  LAST_ACCESS_TIME INT NOT NULL,
  MAX_INACTIVE_INTERVAL INT NOT NULL,
  EXPIRY_TIME INT NOT NULL,
  PRINCIPAL_NAME TEXT DEFAULT NULL
) ;

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID INT NOT NULL,
  ATTRIBUTE_NAME TEXT NOT NULL,
  ATTRIBUTE_BYTES bytea NOT NULL,
  PRIMARY KEY (SESSION_PRIMARY_ID,ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
) ;*/

