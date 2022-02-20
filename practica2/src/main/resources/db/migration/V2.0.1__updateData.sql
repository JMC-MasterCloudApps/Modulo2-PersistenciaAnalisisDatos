-- Actualizar campo JSON 'asistentes'
UPDATE congreso c
    INNER JOIN (
        SELECT
            JSON_ARRAYAGG(asistente_id) as asistentesArray,
            congreso_id
        FROM congreso_asistente
        GROUP BY congreso_id
    ) ac ON c.id = ac.congreso_id
SET c.asistentes = ac.asistentesArray
;

-- Migrar registros de 'Doctor' y 'No Doctor' => 'Investigador'
INSERT INTO investigador (id, nombre, apellido, universidad_id)
SELECT dnd.id, dnd.nombre, dnd.apellido, dnd.universidad_id FROM
    (
        SELECT id, nombre, apellido, universidad_id FROM doctor d
        UNION
        SELECT id, nombre, apellido, universidad_id FROM no_doctor nd
    ) dnd
;