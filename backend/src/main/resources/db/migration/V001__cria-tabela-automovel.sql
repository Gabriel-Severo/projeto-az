create table automovel (
	id bigint not null primary key,
	marca varchar(60) not null,
	modelo varchar(60) not null,
	valorVenda decimal(19, 2) not null,
	vendido boolean not null

);