USE tiendaOnline;
DROP TABLE IF EXISTS compra;

CREATE TABLE compra(
id_compra bigInt auto_increment primary key,
id_usuario bigInt,
id_prod bigInt,
precio float,
unidades int
);


ALTER TABLE compra ADD FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);
ALTER TABLE compra ADD FOREIGN KEY (id_prod) REFERENCES productos(id_prod);