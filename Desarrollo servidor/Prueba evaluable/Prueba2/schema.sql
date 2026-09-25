CREATE DATABASE IF NOT EXISTS excusa_entrega;
USE excusa_entrega;

CREATE TABLE IF NOT EXISTS EXCUSA_ENTREGA (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ALUMNO VARCHAR(150) NOT NULL,
    CURSO VARCHAR(100),
    EXCUSA TEXT,
    DIAS_RETRASO INT,
    CREDIBILIDAD INT,
    FECHA_ENTREGA DATE,
    APROBADA_POR_PROFESOR TINYINT,
    NIVEL_DRAMA INT
);

INSERT INTO EXCUSA_ENTREGA (ALUMNO, CURSO, EXCUSA, DIAS_RETRASO, CREDIBILIDAD, FECHA_ENTREGA, APROBADA_POR_PROFESOR, NIVEL_DRAMA)
VALUES
('Ana López', 'DAW1', 'Mi perro se comió la tarea y tuve que ir al veterinario', 4, 5, '2026-09-20', 1, 8),
('Luis Perea', 'DAW2', 'Un gato gigante me bloqueó el portátil', 3, 4, '2026-09-21', 0, 7),
('Marta Ruiz', 'DAW1', 'La red no funcionaba y no pude entregar a tiempo', 6, 2, NULL, 0, 9),
('Pablo Marino', 'DAW2', 'Se me cayó el móvil al río y perdí todos los archivos', 2, 3, '2026-09-18', 1, 6),
('Sara Díaz', 'DAW1', 'Mi hermano me robó el portátil por accidente', 5, 5, NULL, 0, 10);
