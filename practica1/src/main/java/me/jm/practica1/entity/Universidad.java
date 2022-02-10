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
public class Universidad {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nombre;
  private String ciudad;
  private String pais;

  public Universidad(String nombre, String ciudad, String pais) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.pais = pais;
  }
}
