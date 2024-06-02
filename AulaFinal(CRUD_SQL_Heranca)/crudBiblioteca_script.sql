/*Criacao do banco crudBiblioteca*/
CREATE DATABASE crudBiblioteca;	

USE crudBiblioteca;

CREATE TABLE aluno(
	ra INTEGER(10) PRIMARY KEY,
	nome VARCHAR(100),
	email VARCHAR(50)
);

CREATE TABLE exemplar(
	codigo INTEGER(10) PRIMARY KEY,
	nome VARCHAR(50),
	qtdPaginas INTEGER(10)
);

CREATE TABLE livro(
	codigo INTEGER(10) PRIMARY KEY,
	isbn CHAR(13),
	edicao INTEGER(10),
	FOREIGN KEY (codigo) REFERENCES exemplar(codigo)
);

CREATE TABLE revista(
	codigo INTEGER(10) PRIMARY KEY,
	issn CHAR(8),
	FOREIGN KEY (codigo) REFERENCES exemplar(codigo)
);

CREATE TABLE aluguel(
	codigo INTEGER(10),
	alunoRa INTEGER(10),
	dataRetirada DATE,
	dataDevolucao DATE,
	PRIMARY KEY (codigo, alunoRa, dataRetirada),
	FOREIGN KEY (codigo) REFERENCES exemplar(codigo),
	FOREIGN KEY (alunoRa) REFERENCES aluno(ra)
);

SHOW TABLES;

DESCRIBE aluno;

DESCRIBE Exemplar;

DESCRIBE revista;

DESCRIBE livro;

DESCRIBE aluguel;