package me.jm.practica2.repository;

import java.util.List;
import me.jm.practica2.dto.Asistente;
import me.jm.practica2.dto.RepresentacionUniversidad;
import me.jm.practica2.entity.Congreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresoRepository extends JpaRepository<Congreso, Long> {

  @Query(value = """
       SELECT i.nombre, i.apellido
       FROM congreso c , investigador i\s
       WHERE c.nombre = ?1
       AND JSON_CONTAINS(c.asistentes, CAST(i.`id` AS json), '$')
      """, nativeQuery = true)
  List<Asistente> findAsistentesByNombre(String nombre);

  @Query(value = """
        SELECT u.nombre, count(*) AS numero
        FROM congreso_asistente ca\s
            JOIN (SELECT d.id, d.universidad_id FROM investigador d ) a
            ON a.id = ca.asistente_id\s
            JOIN universidad u ON a.universidad_id = u.id
        WHERE ca.congreso_id = (SELECT id FROM congreso c WHERE c.nombre = ?1)
        GROUP BY u.nombre\s
        """, nativeQuery = true)
  List<RepresentacionUniversidad> findAsistentesPorUniversidad(String nombre);

}
