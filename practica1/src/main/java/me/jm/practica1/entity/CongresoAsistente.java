package me.jm.practica1.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CongresoAsistente {

  @EmbeddedId
  private CongresoAsistenteId id;

  @ManyToOne
  @MapsId("idCongreso")
  private Congreso congreso;

  @ManyToOne
  @MapsId("idAsistente")
  private Investigador asistente;

  public CongresoAsistente(Congreso congreso, Investigador asistente) {
    this.congreso = congreso;
    this.asistente = asistente;

    this.id = new CongresoAsistenteId(congreso.getId(), asistente.getId());
  }
}
