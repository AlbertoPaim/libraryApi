create database library;

create table autor(
id uuid not null primary key,
name varchar(100) not null,
data_nascimento date not null,
nacionalidade varchar(50) not null,
data_cadastro timestamp,
data_atualizacao timestamp,
id_usuario uuid
)

create table livro (
id uuid not null primary key,
isbn varchar(20) not null unique,
titulo varchar (159) not null,
data_publicacao date not null,
genero varchar(30) not null,
preco numeric not null,
data_cadastro timestamp,
data_atualizacao timestamp,
id_usuario uuid,
id_autor uuid not null references autor(id),
constraint chk_genero check (genero in ('TERROR', 'COMÉDIA', 'FANTASIA', 'AVENTURA', 'ROMANCE'))
)

