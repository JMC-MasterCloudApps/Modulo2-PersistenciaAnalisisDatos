package me.jm.practica2.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AsistenteCongreso implements Asistente {

  public static AsistenteCongreso build(Asistente asistente) {
    return new AsistenteCongreso(asistente.getNombre(), asistente.getApellido());
  }

  private String nombre;
  private String apellido;

  @Override
  public String getNombre() {
    return nombre;
  }

  @Override
  public String getApellido() {
    return apellido;
  }

  @Override
  public String toString() {
    return nombre + " " + apellido;
  }
}
