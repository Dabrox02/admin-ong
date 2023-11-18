-- Insertar datos para la tabla 'organizacion'
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

-- Insertar datos para la tabla 'socio'
INSERT INTO socio (dni, nombres, apellidos, telefono, email, id_sede) VALUES ('37496228-0', 'Alisa', 'Barber', '(257) 897-7629', 'metus.facilisis@hotmail.edu', 5);
INSERT INTO socio (dni, nombres, apellidos, telefono, email, id_sede) VALUES ('46275358-6', 'Adrienne', 'Mckee', '(212) 251-3443', 'nulla.integer.vulputate@hotmail.net', 3);
INSERT INTO socio (dni, nombres, apellidos, telefono, email, id_sede) VALUES ('29180615-5', 'Gabriel', 'Rocha', '1-673-211-7232', 'lorem.vitae@outlook.couk', 3);
INSERT INTO socio (dni, nombres, apellidos, telefono, email, id_sede) VALUES ('22246549-4', 'Jasper', 'Gamble', '1-914-758-7254', 'ligula.aliquam.erat@google.net', 3);
INSERT INTO socio (dni, nombres, apellidos, telefono, email, id_sede) VALUES ('17158299-7', 'Odette', 'Meadows', '(797) 914-8381', 'ut.cursus.luctus@icloud.org', 1);

-- Insertar datos para la tabla 'pago'
INSERT INTO pago (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2022-02-25', 'minima', 10, 1);
INSERT INTO pago (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2022-09-22', 'minima', 10, 2);
INSERT INTO pago (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2024-03-23', 'minima', 10, 4);
INSERT INTO pago (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2023-02-15', 'media', 20, 2);
INSERT INTO pago (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2024-09-07', 'maxima', 30, 2);


-- SELECT * FROM SEDE SE JOIN ORGANIZACION ORG ON SE.ID_ORGANIZACION = ORG.ID;
-- SELECT * FROM SOCIO SOC JOIN SEDE SE ON SOC.ID_SEDE = SE.ID;
-- SELECT * FROM PAGO PAG JOIN SOCIO SOC ON PAG.ID_SOCIO = SOC.ID;