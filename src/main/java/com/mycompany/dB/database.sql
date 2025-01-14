DROP DATABASE Javamon;
CREATE DATABASE Javamon;
USE Javamon;
CREATE TABLE users(
                      idUsuario integer auto_increment primary key,
                      `name` varchar(20) not null,
                      passwd varchar(18) not null,
                      state char(1) not null default '1',
                      money int default 0,
                      ip varchar(255)
);

CREATE TABLE Pokemon (
                         idPokemon integer auto_increment primary key,
                         idTrainer int,
                         `name` varchar(20) not null,
                         specie varchar(30) not null,
                         type1 varchar(15) not null,
                         type2 varchar(15),
                         hp int not null,
                         atk int not null,
                         def int not null,
                         eAtk int not null,
                         eDef int not null,
                         spd int not null,
                         team boolean,
                         store boolean,
                         move1 int not null default 1,
                         move2 int,
                         move3 int,
                         move4 int,
                         foreign key (idTrainer) references users(idUsuario),
                         foreign key (move1) references moves(idMove),
                         foreign key (move2) references moves(idMove),
                         foreign key (move3) references moves(idMove),
                         foreign key (move4) references moves(idMove)
);
CREATE TABLE moves (
                       idMove int auto_increment primary key,
                       `name` varchar(40) not null,
                       potencia int not null,
                       accuracy int not null,
                       clase varchar(10) not null,
                       priority int not null default 0,
                       `type` varchar(15) not null
);