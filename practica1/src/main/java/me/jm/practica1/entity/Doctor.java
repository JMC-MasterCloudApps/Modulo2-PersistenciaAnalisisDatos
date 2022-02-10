package me.jm.practica1.entity;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Doctor extends Investigador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String tituloTesis;
  private LocalDate fechaDefensa;
  private String calificacion;

  public Doctor(String nombre,
                  String apellido,
                  String tesis,
                  LocalDate inicio,
                  String calificacion,
                  Universidad uni) {

    super.nombre = nombre;
    super.apellido = apellido;
    tituloTesis = tesis;
    fechaDefensa = inicio;
    this.calificacion = calificacion;
    universidad = uni;
  }
}
