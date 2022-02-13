package me.jm.practica1.entity;

import static javax.persistence.CascadeType.ALL;

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
public class NoDoctor extends Investigador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String tituloDoctorado;

  @OneToMany(mappedBy = "becado", cascade = ALL, orphanRemoval = true)
  private List<BecaBecado> becas = new ArrayList<>();

  public NoDoctor(String nombre, String apellido, String doctorado, Universidad uni) {

    super.nombre = nombre;
    super.apellido = apellido;
    tituloDoctorado = doctorado;
    universidad = uni;
  }

  @Override
  public String toString() {
    return "NoDoctor {" +
        "id=" + id +
        ", nombre=" + nombre +
        ", tituloDoctorado=" + tituloDoctorado +
        ", universidad=" + universidad +
        "}";
  }
}
