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

-- Insertar datos para la tabla 'socio'
INSERT INTO banco (nombre_banco, numero_cuenta, id_socio) VALUES ('Banco A', '123456789', 1);
INSERT INTO banco (nombre_banco, numero_cuenta, id_socio) VALUES ('Banco B', '987654321', 2);
INSERT INTO banco (nombre_banco, numero_cuenta, id_socio) VALUES ('Banco C', '555555555', 3);
INSERT INTO banco (nombre_banco, numero_cuenta, id_socio) VALUES ('Banco D', '777777777', 4);
INSERT INTO banco (nombre_banco, numero_cuenta, id_socio) VALUES ('Banco E', '999999999', 5);

-- Insertar datos para la tabla 'pago'
INSERT INTO cuota (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2022-02-25', 'minima', 10, 1);
INSERT INTO cuota (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2022-09-22', 'minima', 10, 2);
INSERT INTO cuota (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2024-03-23', 'minima', 10, 4);
INSERT INTO cuota (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2023-02-15', 'media', 20, 2);
INSERT INTO cuota (fecha_pago, tipo_cuota, valor_cuota, id_socio) VALUES ('2024-09-07', 'maxima', 30, 2);

-- Insertar datos para la tabla 'voluntario'
INSERT INTO voluntario (dni, nombres, apellidos, telefono, email, disponibilidad, profesion, tipo_voluntario, id_sede) VALUES ('15308944-2', 'Alan', 'Mullins', '1-565-354-2344', 'justo@google.com', 'Si', 'lectus. Cum', 'administrativo', 1);
INSERT INTO voluntario (dni, nombres, apellidos, telefono, email, disponibilidad, profesion, tipo_voluntario, id_sede) VALUES ('28356681-1', 'Idona', 'House', '1-938-871-8582', 'varius.et.euismod@aol.edu', 'Si', 'malesuada malesuada.', 'sanitario', 2);
INSERT INTO voluntario (dni, nombres, apellidos, telefono, email, disponibilidad, profesion, tipo_voluntario, id_sede) VALUES ('3341180-4', 'Veronica', 'James', '(685) 636-9111', 'praesent.interdum.ligula@outlook.ca', 'No', 'parturient', 'sanitario', 3);
INSERT INTO voluntario (dni, nombres, apellidos, telefono, email, disponibilidad, profesion, tipo_voluntario, id_sede) VALUES ('36563665-6', 'Kane', 'Ewing', '1-121-474-1744', 'malesuada@aol.ca', 'Si', 'mi fringilla', 'administrativo', 3);
INSERT INTO voluntario (dni, nombres, apellidos, telefono, email, disponibilidad, profesion, tipo_voluntario, id_sede) VALUES ('14803543-1', 'Grady', 'Stewart', '1-732-376-4825', 'adipiscing.elit@hotmail.couk', 'Si', 'Curae', 'administrativo', 5);

-- Insertar datos para la tabla 'refugio'
INSERT INTO refugio (pais, estado, direccion) VALUES ('China', 'Gyeonggi', '6002 Luctus Rd.');
INSERT INTO refugio (pais, estado, direccion) VALUES ('Austria', 'Gavleborgs lan', 'Ap #442-169 Non Rd.');
INSERT INTO refugio (pais, estado, direccion) VALUES ('New Zealand', 'Jalisco', '7494 Aliquet. Road');
INSERT INTO refugio (pais, estado, direccion) VALUES ('Nigeria', 'Zamboanga Peninsula', 'P.O. Box 282, 2708 Mauris St.');
INSERT INTO refugio (pais, estado, direccion) VALUES ('South Korea', 'North Chungcheong', 'Ap #653-9230 Lacus. Rd.');


-- Insertar datos para la tabla 'envio'
INSERT INTO envio (fecha_salida, id_refugio) VALUES ('2022-12-27', 3);
INSERT INTO envio (fecha_salida, id_refugio) VALUES ('2023-06-09', 2);
INSERT INTO envio (fecha_salida, id_refugio) VALUES ('2023-09-03', 5);
INSERT INTO envio (fecha_salida, id_refugio) VALUES ('2024-06-14', 2);
INSERT INTO envio (fecha_salida, id_refugio) VALUES ('2024-03-19', 1);

-- Insertar datos para la tabla 'sede_envio'
INSERT INTO sede_envio (id_envio, id_sede) VALUES (1, 1);
INSERT INTO sede_envio (id_envio, id_sede) VALUES (2, 1);
INSERT INTO sede_envio (id_envio, id_sede) VALUES (3, 1);
INSERT INTO sede_envio (id_envio, id_sede) VALUES (5, 2);
INSERT INTO sede_envio (id_envio, id_sede) VALUES (4, 3);

-- Insertar datos para la tabla 'carga'
INSERT INTO carga (tipo_carga, descripcion, toneladas, unidades, id_envio) VALUES ('material', 'granos, harinas', 7, NULL, 1);
INSERT INTO carga (tipo_carga, descripcion, toneladas, unidades, id_envio) VALUES ('humanitario', '10 medicos, 20 enfermeros', NULL, NULL, 2);
INSERT INTO carga (tipo_carga, descripcion, toneladas, unidades, id_envio) VALUES ('material', 'antibioticos', NULL, 500, 3);
INSERT INTO carga (tipo_carga, descripcion, toneladas, unidades, id_envio) VALUES ('material', 'frutas', 43, NULL, 4);
INSERT INTO carga (tipo_carga, descripcion, toneladas, unidades, id_envio) VALUES ('humanitario', '5 ingenieros', NULL, NULL, 5);

-- Insertar datos para la tabla 'mision'
INSERT INTO mision (id_voluntario, id_carga) VALUES (1, 2);
INSERT INTO mision (id_voluntario, id_carga) VALUES (1, 5);
INSERT INTO mision (id_voluntario, id_carga) VALUES (2, 2);
INSERT INTO mision (id_voluntario, id_carga) VALUES (2, 5);
INSERT INTO mision (id_voluntario, id_carga) VALUES (3, 2);
INSERT INTO mision (id_voluntario, id_carga) VALUES (4, 5);
INSERT INTO mision (id_voluntario, id_carga) VALUES (5, 2);





-- SELECT * FROM SEDE SE JOIN ORGANIZACION ORG ON SE.ID_ORGANIZACION = ORG.ID;
-- SELECT * FROM SOCIO SOC JOIN SEDE SE ON SOC.ID_SEDE = SE.ID;
-- SELECT * FROM PAGO PAG JOIN SOCIO SOC ON PAG.ID_SOCIO = SOC.ID;

