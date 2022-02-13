package me.jm.practica1.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Congreso {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  private String nombre;
  private String ciudad;
  private String pais;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;

  @OneToMany(mappedBy = "asistente", cascade = ALL, orphanRemoval = true)
  private List<CongresoAsistente> asistentes = new ArrayList<>();

  public Congreso(String nombre, String ciudad, String pais, LocalDate fechaInicio, LocalDate fechaFin) {

    this.nombre = nombre;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }
}
