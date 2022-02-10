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
public class Beca {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nombre;
  private double cantidad;

  public Beca(String nombre, double cantidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
  }
}
