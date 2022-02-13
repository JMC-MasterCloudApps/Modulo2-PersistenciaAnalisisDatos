package me.jm.practica1.repository;

import java.util.List;
import me.jm.practica1.dto.Asistente;
import me.jm.practica1.dto.RepresentacionUniversidad;
import me.jm.practica1.entity.Congreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresoRepository extends JpaRepository<Congreso, Long> {

  @Query(value = """
      select a.nombre, a.apellido
      FROM congreso_asistente ca join\s
          (SELECT id, nombre, apellido from doctor d UNION SELECT id, nombre, apellido from no_doctor nd) a
          on a.id = ca.asistente_id\s
      WHERE ca.congreso_id = (SELECT id FROM congreso c WHERE c.nombre = ?1);
      """, nativeQuery = true)
  List<Asistente> findAsistentesByNombre(String nombre);

  @Query(value = """
        SELECT u.nombre, count(*) as numero
        FROM congreso_asistente ca\s
            join (SELECT d.id, d.universidad_id from doctor d UNION SELECT nd.id, nd.universidad_id from no_doctor nd) a
            on a.id = ca.asistente_id\s
            JOIN universidad u on a.universidad_id = u.id
        WHERE ca.congreso_id = (SELECT id FROM congreso c WHERE c.nombre = 'Amigos de las matemáticas')
        group by u.nombre\s
        """, nativeQuery = true)
  List<RepresentacionUniversidad> findAsistentesPorUniversidad(String nombre);

}
