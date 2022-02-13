package me.jm.practica1.repository;

import java.util.List;
import me.jm.practica1.dto.Asistente;
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

}
