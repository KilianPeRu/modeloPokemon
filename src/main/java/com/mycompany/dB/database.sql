DROP
DATABASE IF EXISTS Javamon;
CREATE
DATABASE Javamon;
USE
Javamon;
CREATE TABLE users
(
    idUsuario integer auto_increment primary key,
    `name`    varchar(20) not null,
    passwd    varchar(18) not null,
    state     char(1)     not null default '1',
    money     int                  default 0,
    ip        varchar(255)
);

CREATE TABLE moves
(
    idMove   int auto_increment primary key,
    `name`   varchar(40) not null,
    potencia int         not null,
    accuracy int         not null,
    clase    varchar(10) not null,
    priority int         not null default 0,
    `type`   varchar(15) not null
);

CREATE TABLE Pokemon
(
    idPokemon integer auto_increment primary key,
    idTrainer int,
    `name`    varchar(20) not null,
    specie    varchar(30) not null,
    type1     varchar(15) not null,
    type2     varchar(15),
    hp        int         not null,
    atk       int         not null,
    def       int         not null,
    eAtk      int         not null,
    eDef      int         not null,
    spd       int         not null,
    team      boolean,
    store     boolean,
    move1     int         not null default 1,
    move2     int,
    move3     int,
    move4     int,
    foreign key (idTrainer) references users (idUsuario),
    foreign key (move1) references moves (idMove),
    foreign key (move2) references moves (idMove),
    foreign key (move3) references moves (idMove),
    foreign key (move4) references moves (idMove)
);

INSERT INTO users(`name`, passwd, state)
VALUES
-- BOTS
('betabot1', 'betabot1123', 1),
('betabot2', 'betabot2123', 1),
('betabot3', 'betabot3123', 1),
('betabot4', 'betabot4123', 1),
('betabot5', 'betabot5123', 1),
-- USER BETA
('betauser1', 'betauser123', 1);


INSERT INTO moves(`name`, potencia, accuracy, clase, priority, `type`)
VALUES
-- Agua:
('Burbuja', 40, 100, 'Especial', 0, 'Agua'),
('Aqua Jet', 40, 100, 'Fisico', 1, 'Agua'),
('Acua cola', 90, 90, 'Fisico', 0, 'Agua'),
('Salpika Surf', 90, 100, 'Especial', 0, 'Agua'),
('Agua Lodosa', 90, 90, 'Especial', 0, 'Agua'),
-- Acero:
('Ala Acero', 70, 100, 'Fisico', 0, 'Acero'),
('Puno Bala', 40, 100, 'Fisico', 1, 'Acero'),
('Bomba Iman', 60, 100, 'Fisico', 0, 'Acero'),
('Disparo Espejo', 60, 100, 'Especial', 0, 'Acero'),
('Garra metal', 60, 100, 'Fisico', 0, 'Acero'),
('Cola Ferrea', 100, 80, 'Fisico', 0, 'Acero'),
-- Bicho:
('Aguijon Letal', 50, 100, 'Fisico', 0, 'Bicho'),
('Zumbido', 90, 100, 'Especial', 0, 'Bicho'),
('Megacuerno', 120, 85, 'Fisico', 0, 'Bicho'),
('Tijera X', 70, 100, 'Fisico', 0, 'Bicho'),
-- Dragon:
('Carga Dragon', 100, 85, 'Fisico', 0, 'Dragon'),
('Garra Dragon', 80, 100, 'Fisico', 0, 'Dragon'),
('DragoAliento', 60, 100, 'Especial', 0, 'Dragon'),
('Cometa Dragon', 120, 70, 'Especial', 0, 'Dragon'),
('VastoImpacto', 60, 100, 'Fisico', 0, 'Dragon'),
-- Electrico:
('Rayo', 90, 100, 'Especial', 0, 'Electrico'),
('Trueno', 110, 75, 'Especial', 0, 'Electrico'),
('Puño Trueno', 75, 100, 'Fisico', 0, 'Electrico'),
('Chispa', 60, 100, 'Fisico', 0, 'Electrico'),
('Onda Voltio', 60, 100, 'Especial', 0, 'Electrico'),
('Pikaturbo', 50, 100, 'Fisico', 0, 'Electrico'),
('Impactrueno', 40, 100, 'Especial', 0, 'Electrico'),
-- Fantasma:
('Bola Sombra', 90, 100, 'Especial', 0, 'Fantasma'),
('Garra Umbria', 70, 100, 'Especial', 0, 'Fantasma'),
('Viento Aciago', 60, 100, 'Especial', 0, 'Fantasma'),
('Puno Furia', 60, 100, 'Fisico', 0, 'Fantasma'),
('Sombra Vil', 40, 100, 'Fisico', 1, 'Fantasma'),
('Hueso Sombrio', 80, 100, 'Fisico', 0, 'Fantasma'),
-- Fuego:
('Ascuas', 40, 100, 'Especial', 0, 'Fuego'),
('Lanzallamas', 90, 100, 'Especial', 0, 'Fuego'),
('Puno Fuego', 70, 100, 'Fisico', 0, 'Fuego'),
('Rueda Fuego', 50, 100, 'Fisico', 0, 'Fuego'),
('Patada Ignea', 85, 90, 'Fisico', 0, 'Fuego'),
('Onda Ignea', 95, 90, 'Especial', 0, 'Fuego'),
('Fuego Sagrado', 100, 100, 'Fisico', 0, 'Fuego'),
-- Hada:
('Fuerza Lunar', 95, 100, 'Especial', 0, 'Hada'),
('Carantona', 90, 90, 'Fisico', 0, 'Hada'),
('Viento Feerico', 40, 100, 'Especial', 0, 'Hada'),
('Beso Drenaje', 50, 100, 'Especial', 0, 'Hada'),
('Brillo Magico', 80, 100, 'Especial', 0, 'Hada'),
-- Hielo:
('Puno Hielo', 70, 100, 'Fisico', 0, 'Hielo'),
('Rayo Hielo', 90, 100, 'Especial', 0, 'Hielo'),
('Ventisca', 110, 70, 'Especial', 0, 'Hielo'),
('Chuzos', 85, 100, 'Fisico', 0, 'Hielo'),
('Martillo Hielo', 100, 90, 'Especial', 0, 'Hielo'),
('Esquirla Helada', 40, 100, 'Fisico', 1, 'Hielo'),
('Frio Polar', 99999, 30, 'Especial', 0, 'Hielo'),
-- Lucha:
('Onda Vacio', 40, 100, 'Especial', 1, 'Lucha'),
('Ultrapuño', 40, 100, 'Fisico', 1, 'Lucha'),
('Onda Certera', 120, 75, 'Especial', 0, 'Lucha'),
('Esfera Aural', 80, 100, 'Especial', 0, 'Lucha'),
('Demolicion', 75, 100, 'Fisico', 0, 'Lucha'),
('Puntapie', 65, 100, 'Fisico', 0, 'Lucha'),
('Machada', 100, 90, 'Fisico', 0, 'Lucha'),
('Desquite', 60, 100, 'Especial', -1, 'Lucha'),
('Golpe Roca', 40, 100, 'Fisico', 0, 'Lucha'),
-- Normal:
('Placaje', 40, 100, 'Fisico', 0, 'Normal'),
('Derribo', 90, 85, 'Fisico', 0, 'Normal'),
('Velocidad Extrema', 80, 100, 'Fisico', 2, 'Normal'),
('Ataque Rapido', 40, 100, 'Fisico', 1, 'Normal'),
('Fuerza', 80, 100, 'Fisico', 0, 'Normal'),
('Guillotina', 99999, 30, 'Fisico', 0, 'Normal'),
('Imagen', 70, 100, 'Fisico', 0, 'Normal'),
('Cuchillada', 70, 100, 'Fisico', 0, 'Normal'),
('Mega Patada', 120, 75, 'Fisico', 0, 'Normal'),
('Perforador', 99999, 30, 'Fisico', 0, 'Normal'),
('Vozarron', 90, 100, 'Especial', 0, 'Normal'),
('Triataque', 80, 100, 'Especial', 0, 'Normal'),
('Poder Oculto', 60, 100, 'Especial', 0, 'Normal'),
-- Planta:
('Follaje', 40, 100, 'Fisico', 0, 'Planta'),
('Fito Impulso', 55, 100, 'Fisico', 0, 'Planta'),
('Hoja Aguda', 90, 100, 'Fisico', 0, 'Planta'),
('Energibola', 90, 100, 'Especial', 0, 'Planta'),
('Bomba germen', 80, 100, 'Fisico', 0, 'Planta'),
('Gigadrenado', 60, 100, 'Especial', 0, 'Planta'),
-- Psiquico:
('Psiquico', 90, 100, 'Especial', 0, 'Psiquico'),
('Paranormal', 50, 100, 'Especial', 0, 'Psiquico'),
('Psico-corte', 70, 100, 'Fisico', 0, 'Psiquico'),
('Psicocolmillo', 85, 100, 'Fisico', 0, 'Psiquico'),
('Bola neblina', 95, 90, 'Especial', 0, 'Psiquico'),
('Cabezazo zen', 90, 100, 'Fisico', 0, 'Psiquico'),
-- Roca:
('Roca Veloz', 40, 100, 'Fisico', 1, 'Roca'),
('Roca Afilada', 100, 85, 'Fisico', 0, 'Roca'),
('Avalancha', 75, 90, 'Fisico', 0, 'Roca'),
('Lanzarrocas', 50, 100, 'Fisico', 0, 'Roca'),
('Poder Pasadp', 60, 100, 'Especial', 0, 'Roca'),
('Joya de Luz', 80, 100, 'Especial', 0, 'Roca'),
-- Siniestro:
('Pulso Umbrio', 80, 100, 'Especial', 0, 'Siniestro'),
('Tajo Umbrio', 70, 100, 'Fisico', 0, 'Siniestro'),
('Pulso Umbrio', 80, 100, 'Especial', 0, 'Siniestro'),
('Golpe Bajo', 80, 100, 'Fisico', 0, 'Siniestro'),
('Desarme', 65, 100, 'Fisico', 0, 'Siniestro'),
('Alarido', 55, 100, 'Especial', 0, 'Siniestro'),
('Triturar', 80, 100, 'Fisico', 0, 'Siniestro'),
('Mordisco', 60, 100, 'Fisico', 0, 'Siniestro'),
-- Tierra:
('Terremoto', 100, 100, 'Fisico', 0, 'Tierra'),
('Fisura', 99999, 30, 'Fisico', 0, 'Tierra'),
('Tierra Viva', 90, 100, 'Especial', 0, 'Tierra'),
('Fuerza Equina', 95, 90, 'Fisico', 0, 'Tierra'),
('Bomba Fango', 60, 100, 'Especial', 0, 'Tierra'),
-- Veneno:
('Onda toxica', 95, 100, 'Especial', 0, 'Veneno'),
('Carga Toxica', 60, 100, 'Especial', 0, 'Veneno'),
('Lanzamugre', 120, 80, 'Fisico', 0, 'Veneno'),
('Veneno X', 70, 100, 'Fisico', 0, 'Veneno'),
('Picotazo Veneno', 15, 100, 'Fisico', 0, 'Veneno'),
('Cola Veneno', 90, 90, 'Fisico', 0, 'Veneno'),
('Bomba Acida', 90, 100, 'Especial', 0, 'Veneno'),
-- Volador:
('Aire afilado', 60, 100, 'Especial', 0, 'Volador'),
('Tajo Aereo', 75, 90, 'Especial', 0, 'Volador'),
('Huracan', 110, 75, 'Especial', 0, 'Volador'),
('Ataque Ala', 60, 100, 'Fisico', 0, 'Volador'),
('Ascenso Draco', 120, 100, 'Fisico', 0, 'Volador'),
('Acróbata', 55, 100, 'Fisico', 0, 'Volador'),
('Vuelo', 90, 90, 'Fisico', 0, 'Volador'),
('Aerochorro', 100, 100, 'Especial', 0, 'Volador');

INSERT INTO Pokemon(idTrainer, `name`, specie, type1, type2, hp, atk, def, eAtk, eDef, spd, team, move1, move2, move3,
                    move4)
VALUES (1, 'RattataBeta', 'Rattata', 'Normal', null, 30, 56, 35, 25, 35, 72, true, 65, 100, 29, 10),
       (1, 'BulbasaurBeta', 'Bulbasaur', 'Planta', 'Veneno', 45, 49, 49, 65, 65, 45, true, 75, 80, 112, 63),
       (1, 'MagnemiteBeta', 'Magnemite', 'Acero', 'Electrico', 25, 35, 70, 95, 55, 45, true, 27, 63, 9, 24),
       (1, 'AzumarillBeta', 'Azumarill', 'Agua', 'Hada', 100, 50, 80, 60, 80, 50, true, 2, 3, 42, 63),
       (1, 'AbsolBeta', 'Absol', 'Siniestro', null, 65, 130, 60, 75, 60, 75, true, 83, 109, 94, 15);
