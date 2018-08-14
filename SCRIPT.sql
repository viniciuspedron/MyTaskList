create database mytasklist;

create table USUARIO (
LOGIN 		VARCHAR(30) 	not null,
SENHA  		VARCHAR(30) 	not null,
primary key (LOGIN) 
);
 
-- Create table
create table TAREFA (
ID 			INTEGER			not null auto_increment,
TITULO  	VARCHAR(128) 	not null,
DESCRICAO	TEXT,
STATUS 		VARCHAR(30),
primary key (ID)
);

insert into usuario (login,senha) values ("supero", "supero");
insert into tarefa (titulo, descricao, status) values ("Enviar Teste", "Enviar teste para Supero", "Concluído");
