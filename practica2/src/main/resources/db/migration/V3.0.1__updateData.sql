# Incluir 'titulo_doctorado' de 'NoDoctor' como 'formacion' en 'Investigador'
UPDATE investigador i
    INNER JOIN (
        SELECT id, JSON_OBJECT('titulo_doctorado', titulo_doctorado) AS 'formacion'
        FROM no_doctor
    ) nd ON i.id = nd.id
SET i.formacion = nd.formacion;

# Incluir info de 'Doctor' como 'formacion' en 'Investigador'
UPDATE investigador i
    INNER JOIN (
        SELECT id,
               JSON_OBJECT(
                       'titulo_tesis', titulo_tesis,
                       'fecha_defensa', fecha_defensa,
                       'calificacion', calificacion) AS 'formacion'
        FROM doctor
    ) d ON d.id = i.id
SET i.formacion = d.formacion;