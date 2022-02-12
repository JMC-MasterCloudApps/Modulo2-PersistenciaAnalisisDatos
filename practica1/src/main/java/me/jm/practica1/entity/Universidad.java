package me.jm.practica1.entity;

import static javax.persistence.FetchType.LAZY;

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
public class Universidad {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nombre;
  private String ciudad;
  private String pais;

  @OneToMany(fetch = LAZY, mappedBy = "universidad")
  List<Investigador> investigadores;

  public Universidad(String nombre, String ciudad, String pais) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.pais = pais;
  }

  @Override
  public String toString() {

    return "Universidad {" +
        "id=" + id +
        ", nombre=" + nombre +
        ", ciudad=" + ciudad +
        ", pais=" + pais +
        "}";
  }
}
