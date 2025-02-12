CREATE SEQUENCE seq_pk_usuarios START 1;

CREATE TABLE Usuarios (
	codigoUser int PRIMARY KEY DEFAULT nextval('seq_pk_usuarios'),
	nome varchar(100),
	email varchar(100),
	dtNascimento date
);


CREATE SEQUENCE seq_pk_livros START 1;

CREATE TABLE Livros (
	codigoLivro int PRIMARY KEY DEFAULT nextval('seq_pk_livros'),
	titulo varchar(100),
	autor varchar(100),
	anoPublic int
);


CREATE SEQUENCE seq_pk_reservas START 1;
create table Reservas (
	codigoReserva int PRIMARY KEY DEFAULT nextval('seq_pk_reservas'),
	dtInicio date,
	dtFinal date,
	codigoUser int,
	FOREIGN KEY (codigoUser) REFERENCES Usuarios (codigoUser)
);



create table Reservas_Livros (
	codigoLivro int,
	codigoReserva int,
	FOREIGN KEY (codigoLivro) REFERENCES Livros (codigoLivro),
	FOREIGN KEY (codigoReserva) REFERENCES Reservas (codigoReserva)
);
