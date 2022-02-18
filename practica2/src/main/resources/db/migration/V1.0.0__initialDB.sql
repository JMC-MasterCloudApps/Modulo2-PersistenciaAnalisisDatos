-- test.beca definition

CREATE TABLE `beca` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `cantidad` double NOT NULL,
                        `nombre` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.congreso definition

CREATE TABLE `congreso` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `ciudad` varchar(255) DEFAULT NULL,
                            `fecha_fin` date DEFAULT NULL,
                            `fecha_inicio` date DEFAULT NULL,
                            `nombre` varchar(255) DEFAULT NULL,
                            `pais` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.hibernate_sequence definition

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.universidad definition

CREATE TABLE `universidad` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `ciudad` varchar(255) DEFAULT NULL,
                               `nombre` varchar(255) DEFAULT NULL,
                               `pais` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.congreso_asistente definition

CREATE TABLE `congreso_asistente` (
                                      `congreso_id` bigint NOT NULL,
                                      `asistente_id` bigint NOT NULL,
                                      PRIMARY KEY (`asistente_id`,`congreso_id`),
                                      KEY `FKe645ubauntj0jnrtgsdc1ba0m` (`congreso_id`),
                                      CONSTRAINT `FKe645ubauntj0jnrtgsdc1ba0m` FOREIGN KEY (`congreso_id`) REFERENCES `congreso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.doctor definition

CREATE TABLE `doctor` (
                          `id` bigint NOT NULL,
                          `apellido` varchar(255) DEFAULT NULL,
                          `nombre` varchar(255) DEFAULT NULL,
                          `universidad_id` bigint DEFAULT NULL,
                          `calificacion` varchar(255) DEFAULT NULL,
                          `fecha_defensa` date DEFAULT NULL,
                          `titulo_tesis` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK_8522janjbh10lk0yglmpt4yye` (`universidad_id`),
                          CONSTRAINT `FK_8522janjbh10lk0yglmpt4yye` FOREIGN KEY (`universidad_id`) REFERENCES `universidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.investigador definition

CREATE TABLE `investigador` (
                                `id` bigint NOT NULL,
                                `apellido` varchar(255) DEFAULT NULL,
                                `nombre` varchar(255) DEFAULT NULL,
                                `universidad_id` bigint DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FKtjo0as4p0glnfjblwhomljm37` (`universidad_id`),
                                CONSTRAINT `FKtjo0as4p0glnfjblwhomljm37` FOREIGN KEY (`universidad_id`) REFERENCES `universidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.no_doctor definition

CREATE TABLE `no_doctor` (
                             `id` bigint NOT NULL,
                             `apellido` varchar(255) DEFAULT NULL,
                             `nombre` varchar(255) DEFAULT NULL,
                             `universidad_id` bigint DEFAULT NULL,
                             `titulo_doctorado` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FK_i6mnl7vmihgtwkrcrxrqpl00d` (`universidad_id`),
                             CONSTRAINT `FK_i6mnl7vmihgtwkrcrxrqpl00d` FOREIGN KEY (`universidad_id`) REFERENCES `universidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.beca_becado definition

CREATE TABLE `beca_becado` (
                               `beca_id` bigint NOT NULL,
                               `becado_id` bigint NOT NULL,
                               PRIMARY KEY (`beca_id`,`becado_id`),
                               KEY `FKk4v0kalt5fy85asts2ios93co` (`becado_id`),
                               CONSTRAINT `FKhh7jcmklv1iq4sjnbyblbsv16` FOREIGN KEY (`beca_id`) REFERENCES `beca` (`id`),
                               CONSTRAINT `FKk4v0kalt5fy85asts2ios93co` FOREIGN KEY (`becado_id`) REFERENCES `no_doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;