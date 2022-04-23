create table perro (

 id int primary key auto_increment,
 nombre varchar(100) not null,
 raza varchar(100) not null,
 peso varchar(100) not null,
 fechaIngreso datetime null,
 idUsuario int not null,
    foreign key (idUsuario) references usuario(id)
);

insert into perro (nombre, raza, peso, fechaIngreso, idUsuario) values ('Max', 'Pastor Aleman', '10Kg', now(), 1);
insert into perro (nombre, raza, peso, fechaIngreso, idUsuario) values ('Kaiser', 'Doberman', '13Kg', now(), 1);
insert into perro (nombre, raza, peso, fechaIngreso, idUsuario) values ('Lucas', 'Pitbull', '11Kg', now(), 2);