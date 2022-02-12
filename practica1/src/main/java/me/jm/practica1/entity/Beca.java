package me.jm.practica1.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
