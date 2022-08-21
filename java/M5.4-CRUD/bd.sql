--BASE DE DATOS PARA ORACLE
CREATE TABLE PERSONA (
  id int NOT NULL,
  name varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  sex varchar(100) NOT NULL,
  country varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE SEQUENCE PERSONA_SEC
 START WITH     1
 INCREMENT BY   1;

SELECT * FROM PERSONA;


--BASE DE DATOS PARA MYSQL
CREATE TABLE PERSONA (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  sex varchar(100) NOT NULL,
  country varchar(100) NOT NULL,
  PRIMARY KEY (id)
);