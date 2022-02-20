package me.jm.practica2.repository;

import java.util.List;
import me.jm.practica2.dto.InfoBecas;
import me.jm.practica2.dto.InvestigadoresPorUni;
import me.jm.practica2.entity.Investigador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {

  @Query(value = "SELECT *, 0 AS clazz_ FROM investigador", nativeQuery = true)
  List<Investigador> findAllBy();

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

  @Query(value = """
      SELECT nd.nombre,
             nd.apellido,
             count(b.id) as becas,
             IFNULL(sum(b.cantidad), 0) as dinero
       FROM investigador nd
             LEFT JOIN beca_becado bb ON nd.id = bb.becado_id
             LEFT JOIN beca b ON b.id = bb.beca_id
       WHERE formacion -> "$.titulo_doctorado" IS NOT NULL
       GROUP BY (nd.id);
    """, nativeQuery = true)
  List<InfoBecas> findBecasNoDoctores();
}
