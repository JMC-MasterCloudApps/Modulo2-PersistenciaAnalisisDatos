package me.jm.practica1.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Congreso {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nombre;
  private String ciudad;
  private String pais;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;

  public Congreso(String nombre, String ciudad, String pais, LocalDate fechaInicio, LocalDate fechaFin) {

    this.nombre = nombre;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }
}
