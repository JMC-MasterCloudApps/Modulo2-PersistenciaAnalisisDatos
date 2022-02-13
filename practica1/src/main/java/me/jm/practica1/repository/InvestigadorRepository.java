package me.jm.practica1.repository;

import java.util.List;
import me.jm.practica1.dto.InvestigadoresPorUni;
import me.jm.practica1.entity.Investigador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {

  @Query(value = """
    SELECT investigadorUniversidad
    FROM (
        SELECT concat(u.nombre, ' - ', d.nombre, ' ', d.apellido, ' (Doctor)')\s
                as 'investigadorUniversidad',
                u.nombre
        FROM universidad u, doctor d
        WHERE u.id = d.universidad_id\s
        UNION\s
        SELECT concat(u.nombre, ' - ', nd.nombre, ' ', nd.apellido, ' (NO Doctor)')\s
                as 'investigadorUniversidad',
                u.nombre
        FROM universidad u, no_doctor nd
        WHERE u.id = nd.universidad_id\s
        ) as investigadores
    order by investigadores.nombre
  """, nativeQuery = true)
  List<InvestigadoresPorUni> findAllWithTypeAndUniversity();

}
