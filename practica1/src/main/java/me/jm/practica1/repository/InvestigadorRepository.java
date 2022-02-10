package me.jm.practica1.repository;

import me.jm.practica1.entity.Investigador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {

}
