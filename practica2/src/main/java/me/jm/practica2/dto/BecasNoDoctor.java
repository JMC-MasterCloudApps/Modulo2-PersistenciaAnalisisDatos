package me.jm.practica2.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BecasNoDoctor implements InfoBecas {

  public static BecasNoDoctor build(InfoBecas data) {
    return new BecasNoDoctor(data.getNombre(), data.getApellido(), data.getBecas(), data.getDinero());
  }

  private String nombre;
  private String apellido;
  private int becas;
  private double dinero;

  @Override
  public String getNombre() {
    return nombre;
  }

  @Override
  public String getApellido() {
    return apellido;
  }

  @Override
  public int getBecas() {
    return becas;
  }

  @Override
  public double getDinero() {
    return dinero;
  }

  @Override
  public String toString() {
    return nombre + " " + apellido + ", \t\t" + becas + ", \t" + dinero;
  }
}
