package me.jm.practica2.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AsistentesPorUniversidad implements RepresentacionUniversidad {

  public static AsistentesPorUniversidad build(RepresentacionUniversidad data) {
    return new AsistentesPorUniversidad(data.getNombre(), data.getNumero());
  }

  private String nombre;
  private int numero;

  @Override
  public String getNombre() {
    return nombre;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  @Override
  public String toString() {
    return nombre + ": " + numero;
  }

}
