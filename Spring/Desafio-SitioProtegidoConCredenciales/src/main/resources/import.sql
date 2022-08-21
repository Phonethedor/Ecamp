DROP TABLE IF EXISTS users;
create table users(email varchar, password varchar, role varchar);
insert into users (email,password,role) 
values ('correo1@gmail.com','$2a$10$f0eBdkqTzkK1ZcnUxhTKOeMgHT5QgSEdR3TmMQ7J1MWq1UqMnqVme','CLIENT');
insert into users (email,password,role) 
values ('correo2@gmail.com','$2a$10$.ok3D4ipAkGb.o.OyxedEuUW7Dj2SYKcfTKytKWKAn76wB4QCFnvC','ADMIN');
--pepito
--admin