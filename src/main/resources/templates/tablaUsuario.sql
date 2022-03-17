USE tiendaOnline;
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario(
id_usuario bigInt auto_increment primary key,
nombre_usuario varchar(50) NOT NULL,
apellido_usuario varchar(50),
pass_usuario varchar(500) NOT NULL,
email varchar(50) NOT NULL,
fecha_nac varchar(10) NOT NULL
);

insert into usuario(id_usuario,nombre_usuario,apellido_usuario,pass_usuario,email,fecha_nac) values(1,"admin","admin","admin","admin@admin.admin","01-02-2003");