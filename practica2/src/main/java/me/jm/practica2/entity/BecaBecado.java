package me.jm.practica2.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BecaBecado {

  @EmbeddedId
  private BecaBecadoId id;

  @ManyToOne
  @MapsId("idBeca")
  private Beca beca;

  @ManyToOne
  @MapsId("idBecado")
  private NoDoctor becado;

  public BecaBecado (Beca beca, NoDoctor becado) {
    this.beca = beca;
    this.becado = becado;

    this.id = new BecaBecadoId(beca.getId(), becado.getId());
  }
}
