--ORACLE
create table curso (
id_curso INT primary key, 
descripcion VARCHAR2(100),
precio INT
);

create table forma_pago (
id_forma_pago VARCHAR2(50), 
descripcion VARCHAR2(100),
recargo VARCHAR2(100)
);

create table inscripcion(
id_inscripcion INT primary key, 
nombre VARCHAR2(100),
telefono VARCHAR2(22), 
id_curso INT, 
id_forma_pago INT,
foreign key (id_curso) references curso(id_curso));

CREATE SEQUENCE inscripcion_sec 
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE curso_sec
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;

insert into curso values(curso_sec.NEXTVAL,'Java Enterprice Edition', 800000);
insert into curso values(curso_sec.NEXTVAL,'Java Standar Edition', 600000);
insert into curso values(curso_sec.NEXTVAL,'JavaScript ECMA 6', 500000);

insert into forma_pago values ('1598','Tarjeta Credito','10%');
insert into forma_pago values ('1547','Tarjeta Debito','15%');
insert into forma_pago values ('3578','Efectivo','5%');

SELECT * FROM CURSO;
SELECT * FROM FORMA_PAGO;
SELECT * FROM INSCRIPCION;

DROP TABLE CURSO;
DROP TABLE FORMA_PAGO;
DROP TABLE INSCRIPCION;

DROP SEQUENCE CURSO_SEC;
DROP SEQUENCE INSCRIPCION_SEC;

----------------------------------------------
--MYSQL
CRETE DATABASE EDUTECNO;
USE DATABASE EDUTECNO;

create table curso (
id_curso INT primary key auto_increment, 
descripcion VARCHAR(100),
precio INT
);

create table forma_pago (
id_forma_pago VARCHAR(50), 
descripcion VARCHAR(100),
recargo VARCHAR(100)
);

create table inscripcion(
id_inscripcion INT primary key auto_increment, 
nombre varchar(100),
telefono varchar(22), 
id_curso INT, 
id_forma_pago INT,
foreign key (id_curso) references curso(id_curso));

insert into curso values(NULL,'Java Enterprice Edition', 800000);
insert into curso values(NULL,'Java Standar Edition', 600000);
insert into curso values(NULL,'JavaScript ECMA 6', 500000);

insert into forma_pago values ('1598','Tarjeta Credito','10%');
insert into forma_pago values ('1547','Tarjeta Debito','15%');
insert into forma_pago values ('3578','Efectivo','5%');