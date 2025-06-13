create database Biblioteca
--grant select, insert, update, delete  to userapela
go

use Biblioteca
go


create table Editorial (
	id_editorial int identity(1,1) primary key not null,
	nombre varchar(50) not null unique
)
select * from Editorial

create table Autor (
	id_autor int identity(1,1) primary key not null,
	nombre varchar(50) not null unique
)


create table Libro (
	id_libro int identity(1,1) primary key not null,
	titulo varchar(30) not null,
	id_editorial int not null,

	constraint FK_LIBRO_EDITORIAL foreign key (id_editorial)
	references Editorial(id_editorial) on update cascade
)


create table Lector (
	id_lector int identity(1,1) primary key not null,
	nombre varchar (15) not null,
	apellido_p varchar (10) not null,
	apellido_m varchar (10) null
)

create table Autor_Libro (
	id_autor int not null,
	id_libro int not null,

	constraint FK_AL_AUTOR foreign key (id_autor)
	references Autor(id_autor) on update cascade,

	constraint FK_AL_Libro foreign key (id_libro)
	references Libro(id_libro) on update cascade
)


create table Libro_Lector (
	id_libro int not null,
	id_lector int not null,
	fecha_devolucion date not null,

	constraint FK_LL_LIBRO foreign key (id_libro)
	references Libro(id_libro) on update cascade,

	constraint FK_LL_LECTOR foreign key (id_lector)
	references Lector(id_lector) on update cascade
)