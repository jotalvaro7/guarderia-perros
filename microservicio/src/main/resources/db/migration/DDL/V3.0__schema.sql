create table registro_mascota (

 id int primary key auto_increment,
 idMascota int not null,
 fechaIngreso datetime null,
    foreign key (idMascota) references mascota(id)
);

insert into registro_mascota (idMascota, fechaIngreso) values (1, now());
insert into registro_mascota (idMascota, fechaIngreso) values (2, now());
insert into registro_mascota (idMascota, fechaIngreso) values (3, now());
