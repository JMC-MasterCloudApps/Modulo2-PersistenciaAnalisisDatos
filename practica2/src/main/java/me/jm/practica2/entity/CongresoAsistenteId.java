package me.jm.practica2.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CongresoAsistenteId implements Serializable {

  private long idCongreso;
  private long idAsistente;

}