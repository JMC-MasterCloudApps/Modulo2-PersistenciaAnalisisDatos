package me.jm.practica2.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
public class Investigador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  protected String nombre;
  protected String apellido;

  @ManyToOne
  protected Universidad universidad;

  @OneToMany(mappedBy = "congreso", cascade = ALL, orphanRemoval = true)
  private List<CongresoAsistente> congresos = new ArrayList<>();

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
