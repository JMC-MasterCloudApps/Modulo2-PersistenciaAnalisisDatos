INSERT INTO beca (id,cantidad,nombre) VALUES
                                            (1, 18500.0,'Beca Ramón y Cajal'),
                                            (2, 85500.0,'Stephen Hawking'),
                                            (3, 25100.0,'Fundación amigos de Donatello');

INSERT INTO universidad (id,ciudad,nombre,pais) VALUES
                                                      (1, 'Granada','Universidad de Granada','España'),
                                                      (2, 'Madrid','Universidad Politécnica de Madrid','España'),
                                                      (3, 'Lappeenranta','Lappeenranta University of Technology','Finlandia');

INSERT INTO congreso (id,ciudad,fecha_fin,fecha_inicio,nombre,pais) VALUES
                                                                          (1, 'Cáceres','2022-03-17','2022-03-15','Amigos de las matemáticas','España'),
                                                                          (2, 'Helsinki','2022-05-07','2022-05-01','Thunderbolt congress','Finland'),
                                                                          (3, 'Las Vegas','2022-11-23','2022-11-17','WWW congress','USA');

INSERT INTO no_doctor (id,apellido,nombre,universidad_id,titulo_doctorado) VALUES
                                                                                    (1,'Bernini','Roberto',1,'Chem. 1742'),
                                                                                    (2,'Dawson','Laura',3,'Metallic abrasion'),
                                                                                    (3,'Aguilera','Ana',1,'Worldwide travelling'),
                                                                                    (4,'Azpilicueta','Michelle',2,'Anti-bodies Alpha3'),
                                                                                    (5,'Spontiakov','Dimitry',2,'Basic ferments'),
                                                                                    (6,'Vilchez','Miguel',3,'Repulsión de flujo marino');

INSERT INTO doctor (id,apellido,nombre,universidad_id,calificacion,fecha_defensa,titulo_tesis) VALUES
                                                                                                        (7,'Williams','Victoria',2,'8.5','2001-02-14','Big stars'),
                                                                                                        (8,'Paulov','Alfred',3,'7.9','2011-07-14','Underground waves'),
                                                                                                        (9,'Fajardo','José',1,'9.1','2011-11-11','Ligamentos y tejidos tendiniosos'),
                                                                                                        (10,'Johnson','Carol',1,'9.6','2019-05-22','Bipolar behaviour');

INSERT INTO beca_becado (beca_id,becado_id) VALUES
                                                     (1,1),
                                                     (1,2),
                                                     (2,2),
                                                     (2,5),
                                                     (3,5);

INSERT INTO congreso_asistente (congreso_id,asistente_id) VALUES
                                                                   (1,1),
                                                                   (1,2),
                                                                   (1,7),
                                                                   (1,8),
                                                                   (1,9),
                                                                   (2,2),
                                                                   (2,7),
                                                                   (2,9),
                                                                   (3,9);

INSERT INTO hibernate_sequence (next_val) VALUES
    (11);