package me.jm.practica1.repository;

import me.jm.practica1.entity.Congreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresoRepository extends JpaRepository<Congreso, Long> {

}
