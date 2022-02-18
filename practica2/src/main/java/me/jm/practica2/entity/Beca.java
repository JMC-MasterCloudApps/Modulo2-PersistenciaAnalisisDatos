package me.jm.practica2.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Beca {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  private String nombre;
  private double cantidad;

  @OneToMany(mappedBy = "beca", cascade = ALL, orphanRemoval = true)
  private List<BecaBecado> becados = new ArrayList<>();

  public Beca(String nombre, double cantidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
  }

  @Override
  public String toString() {
    return "Beca { " +
        "id=" + id +
        ", nombre=" + nombre +
        ", cantidad=" + cantidad +
        "}";
  }
}
