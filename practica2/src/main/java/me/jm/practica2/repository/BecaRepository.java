package me.jm.practica2.repository;

import me.jm.practica2.entity.Beca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BecaRepository extends JpaRepository<Beca, Long> {

}
