insert into productos(id_prod,titulo,descripcion,precio,descuento) values(1,"pan integral","pan con trigo integrado.",12.50,5);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(2,"pan normal","pan común, el de toda la vida.",20.10,4);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(3,"pan cuadrado","pan con forma cuadrada.",21.30,3);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(4,"pan triangular","pan triangular.",23.25,2);
insert into productos(id_prod,titulo,descripcion,precio,descuento) values(5,"panceta","pan con panceta integrada.",43.95,1);

insert into rol(id_rol,nombre_rol) values(1,"admin");
insert into rol(id_rol,nombre_rol) values(2,"cliente");

insert into usuario(id_usuario,nombre_usuario,apellido_usuario,pass_usuario,email,fecha_nac) values(1,"admin","admin","$2a$10$CVR4J4jjnI8/zRzZ1nK94.bBzzRfGYWvezgRE90nyy7osX9zupRaK","admin@admin.admin","01-02-2003");
insert into usuario(id_usuario,nombre_usuario,apellido_usuario,pass_usuario,email,fecha_nac) values(2,"cliente","cliente","$2a$10$CVR4J4jjnI8/zRzZ1nK94.bBzzRfGYWvezgRE90nyy7osX9zupRaK","cliente@cliente.cliente","01-02-2003");



insert into rol_user(id_usuario,id_rol) values(1,1);
insert into rol_user(id_usuario,id_rol) values(2,2);
select r.id_rol as 'id', r.nombre_rol as 'nombre' from rol_user ru inner join rol r on r.id_rol = ru.id_rol where ru.id_usuario = 2;