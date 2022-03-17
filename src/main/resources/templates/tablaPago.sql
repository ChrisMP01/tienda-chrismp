USE NS7SQs2uYl;
DROP TABLE IF EXISTS pago;

CREATE TABLE pago(
idPago bigInt auto_increment primary key,
numTarjeta int,
titular varchar(50),
codSeguridad int,
dirFacturacion varchar(50)
);