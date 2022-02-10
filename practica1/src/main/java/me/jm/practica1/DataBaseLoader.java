package me.jm.practica1;

import static java.time.LocalDate.of;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import me.jm.practica1.entity.Beca;
import me.jm.practica1.entity.Congreso;
import me.jm.practica1.entity.Doctor;
import me.jm.practica1.entity.Investigador;
import me.jm.practica1.entity.NoDoctor;
import me.jm.practica1.entity.Universidad;
import me.jm.practica1.repository.BecaRepository;
import me.jm.practica1.repository.CongresoRepository;
import me.jm.practica1.repository.InvestigadorRepository;
import me.jm.practica1.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataBaseLoader implements CommandLineRunner {

  final UniversidadRepository uniRepo;
  final BecaRepository becaRepo;
  final CongresoRepository congresoRepo;
  final InvestigadorRepository investigadorRepo;

  @Override
  public void run(String... args) throws Exception {

    crearUniversidades();
    crearBecas();
    crearCongresos();
    crearInvestigadores();
    // Guardando algunos productos
//    repository.save(new Producto("Apple Macbook", new Version("1.0",new Date(System.currentTimeMillis()-50000000))));
//    repository.save(new Producto("Apple Macbook Pro", new Version("1.5",new Date(System.currentTimeMillis()))));

    // Recupera productos
//    List<Producto> productos = repository.findAll();
    log("Productos con findAll():");
    log("----------------------------------------");
//    muestraDatos(productos);

  }

  private void log(String message) {
    System.out.println(message);
  }

  void crearUniversidades() {

    log("Creando universidades...");
    uniRepo.save(new Universidad("Universidad de Granada", "Granada", "España"));
    uniRepo.save(new Universidad("Universidad Politécnica de Madrid", "Madrid", "España"));
    uniRepo.save(new Universidad("Lappeenranta University of Technology", "Lappeenranta", "Finlandia"));
  }

  void crearBecas() {

    log("Creando becas...");
    becaRepo.save(new Beca("Beca Ramón y Cajal", 18500));
    becaRepo.save(new Beca("Stephen Hawking", 85500));
    becaRepo.save(new Beca("Fundación amigos de Donatello", 25100));
  }

  void crearCongresos() {

    congresoRepo.save(new Congreso("Amigos de las matemáticas", "Cáceres", "España", of(2022, 3, 15), of(2022, 3, 17)));
    congresoRepo.save(new Congreso("Thunderbolt congress", "Helsinki", "Finland", of(2022, 5, 1), of(2022, 5, 7)));
    congresoRepo.save(new Congreso("WWW congress", "Las Vegas", "USA", of(2022, 11, 17), of(2022, 11, 23)));

  }

  void crearInvestigadores() {

    log("Creando universidades...");
    var ugr = uniRepo.save(new Universidad("Universidad de Granada", "Granada", "España"));
    var upm = uniRepo.save(new Universidad("Universidad Politécnica de Madrid", "Madrid", "España"));
    var lut = uniRepo.save(new Universidad("Lappeenranta University of Technology", "Lappeenranta", "Finlandia"));

    log("Creando investigadors");
    investigadorRepo.save(new NoDoctor("Roberto", "Bernini", "Chem. 1742", ugr));
    investigadorRepo.save(new NoDoctor("Laura", "Dawson", "Metallic abrasion", lut));
    investigadorRepo.save(new NoDoctor("Ana", "Aguilera", "Worldwide travelling", ugr));
    investigadorRepo.save(new NoDoctor("Michelle", "Azpilicueta", "Anti-bodies Alpha3", upm));
    investigadorRepo.save(new NoDoctor("Dimitry", "Spontiakov", "Basic ferments", upm));
    investigadorRepo.save(new NoDoctor("Miguel", "Vilchez", "Repulsión de flujo marino", lut));

    investigadorRepo.save(new Doctor("Victoria", "Williams", "Big stars", of(2001, 2, 14), "8.5", upm));
    investigadorRepo.save(new Doctor("Alfred", "Paulov", "Underground waves", of(2011, 7, 14), "7.9", lut));
    investigadorRepo.save(new Doctor("José", "Fajardo", "Ligamentos y tejidos tendiniosos", of(2011, 11, 11), "9.1", ugr));
    investigadorRepo.save(new Doctor("Carol", "Johnson", "Bipolar behaviour", of(2019, 5, 22), "9.6", ugr));
  }

//  private static void muestraDatos(List<Producto> datos) {
//    for (Producto p : datos) {
//      System.out.println(p);
//    }
//    System.out.println();
//  }


}
