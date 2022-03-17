USE tiendaOnline;

DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS rol_user;

CREATE TABLE rol(
id_rol bigInt auto_increment primary key,
nombre_rol varchar(20)
);

CREATE TABLE rol_user(
id_user bigint auto_increment primary key,
id_rol bigint,

CONSTRAINT FK_ROL_1 FOREIGN KEY (id_user) REFERENCES usuario (id_usuario) ON DELETE CASCADE,
CONSTRAINT FK_ROL_2 FOREIGN KEY (id_rol) REFERENCES rol (id_rol) ON DELETE CASCADE
);

insert into rol(id_rol,nombre_rol) values(1,"admin");
insert into rol(id_rol,nombre_rol) values(2,"cliente");

insert into rol_user(id_user,id_rol) values(1,1);
select r.id_rol as 'id', r.nombre_rol as 'nombre' from rol_user ru inner join rol r on r.id_rol = ru.id_rol where ru.id_user = 2;