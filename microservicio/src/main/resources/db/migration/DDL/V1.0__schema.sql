create table usuario (
 id int primary key auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 identificacion varchar(100) not null,
 numeroCelular varchar(100) not null
);

insert into usuario (nombre, apellido, identificacion, numeroCelular) values ('Jhon', 'Doe', '123456', '3203980337');
insert into usuario (nombre, apellido, identificacion, numeroCelular) values ('Martin', 'Jobs', '720725', '3148067139');
insert into usuario (nombre, apellido, identificacion, numeroCelular) values ('Carlos', 'Caceres', '01010', '314807777');