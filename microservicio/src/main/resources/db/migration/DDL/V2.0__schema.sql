create table mascota (

 id int primary key auto_increment,
 nombre varchar(100) not null,
 raza varchar(100) not null,
 peso varchar(100) not null,
 fechaIngreso datetime null,
 idUsuario int not null,
    foreign key (idUsuario) references usuario(id)
);

insert into mascota (nombre, raza, peso, idUsuario) values ('Max', 'Pastor Aleman', '10Kg', 1);
insert into mascota (nombre, raza, peso, idUsuario) values ('Kaiser', 'Doberman', '13Kg', 1);
insert into mascota (nombre, raza, peso, idUsuario) values ('Lucas', 'Pitbull', '11Kg', 2);