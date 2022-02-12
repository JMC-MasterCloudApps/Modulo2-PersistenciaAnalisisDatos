package me.jm.practica1.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Investigador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  protected String nombre;
  protected String apellido;

  @ManyToOne()
  //@JoinColumn(name = "id")
  protected Universidad universidad;

  @Override
  public String toString() {
    return "Investigador {" +
        "id=" + id +
        ", nombre=" + nombre +
        ", apellido=" + apellido +
        ", universidad=" + universidad +
        "}";
  }
}
