package me.jm.practica1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class NoDoctor extends Investigador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String tituloDoctorado;

  public NoDoctor(String nombre, String apellido, String doctorado, Universidad uni) {

    super.nombre = nombre;
    super.apellido = apellido;
    tituloDoctorado = doctorado;
    universidad = uni;
  }
}
