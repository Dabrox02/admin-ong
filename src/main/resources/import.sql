INSERT INTO organizacion (nombre) VALUES ('Tellus Industries');
INSERT INTO organizacion (nombre) VALUES ('Morbi Tristique Industries');
INSERT INTO organizacion (nombre) VALUES ('Laoreet Posuere Industries');
INSERT INTO organizacion (nombre) VALUES ('Ultricies Sem Magna Ltd');
INSERT INTO organizacion (nombre) VALUES ('Erat Corp.');

-- Insertar datos para la tabla 'sede'
INSERT INTO sede (nombre_director, ciudad, pais, id_organizacion) VALUES ('Lucas Burgess', 'Osnabruck', 'Belgium', 2);
INSERT INTO sede (nombre_director, ciudad, pais, id_organizacion) VALUES ('Jordan Curry', 'San Juan del Rio', 'Singapore', 3);
INSERT INTO sede (nombre_director, ciudad, pais, id_organizacion) VALUES ('Hashim Palmer', 'Jeju', 'India', 3);
INSERT INTO sede (nombre_director, ciudad, pais, id_organizacion) VALUES ('Tana Cash', 'Mérida', 'Vietnam', 4);
INSERT INTO sede (nombre_director, ciudad, pais, id_organizacion) VALUES ('Judith Watkins', 'Onitsha', 'United States', 1);

-- SELECT * FROM SEDE SE JOIN ORGANIZACION ORG ON SE.ID_ORGANIZACION = ORG.ID;