package me.jm.practica1.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BecaBecadoId implements Serializable {

  private static final long serialVersionUID = -1102814818718669076L;
  private long becaId;
  private long becadoId;

}
