package me.jm.practica1;

import static java.time.LocalDate.of;
import static java.util.Arrays.asList;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.jm.practica1.entity.Beca;
import me.jm.practica1.entity.BecaBecado;
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

//    crearBecas();
//    crearCongresos();
    crearInvestigadores();

    List<Investigador> productos = investigadorRepo.findAll();
    log("________________________________\nInvestigadores  findAll");
    imprime(productos);
  }

  public static void log(String message) {
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

    log("________________________________\nCreando universidades...");
    var ugr = uniRepo.save(new Universidad("Universidad de Granada", "Granada", "España"));
    var upm = uniRepo.save(new Universidad("Universidad Politécnica de Madrid", "Madrid", "España"));
    var lut = uniRepo.save(new Universidad("Lappeenranta University of Technology", "Lappeenranta", "Finlandia"));


    log("________________________________\nCreando becas...");
    var beca1 = new Beca("Beca Ramón y Cajal", 18500);
    var beca2 = new Beca("Stephen Hawking", 85500);
    var beca3 = new Beca("Fundación amigos de Donatello", 25100);

    log("________________________________\nCreando investigadores...");
    var nDctr1 = new NoDoctor("Roberto", "Bernini", "Chem. 1742", ugr);
    var nDctr2 = new NoDoctor("Laura", "Dawson", "Metallic abrasion", lut);
    var nDctr3 = new NoDoctor("Ana", "Aguilera", "Worldwide travelling", ugr);
    var nDctr4 = new NoDoctor("Michelle", "Azpilicueta", "Anti-bodies Alpha3", upm);
    var nDctr5 = new NoDoctor("Dimitry", "Spontiakov", "Basic ferments", upm);
    var nDctr6 = new NoDoctor("Miguel", "Vilchez", "Repulsión de flujo marino", lut);

    var dctr1 = new Doctor("Victoria", "Williams", "Big stars", of(2001, 2, 14), "8.5", upm);
    var dctr2 = new Doctor("Alfred", "Paulov", "Underground waves", of(2011, 7, 14), "7.9", lut);
    var dctr3 = new Doctor("José", "Fajardo", "Ligamentos y tejidos tendiniosos", of(2011, 11, 11), "9.1", ugr);
    var dctr4 = new Doctor("Carol", "Johnson", "Bipolar behaviour", of(2019, 5, 22), "9.6", ugr);

    nDctr1.setBecas(List.of(new BecaBecado(beca1, nDctr1)));
    nDctr2.setBecas(List.of(new BecaBecado(beca1, nDctr2), new BecaBecado(beca2, nDctr2)));
    nDctr5.setBecas(List.of(new BecaBecado(beca2, nDctr5), new BecaBecado(beca3, nDctr5)));

    List<Investigador> investigadores = List.of(nDctr1, nDctr2, nDctr3, nDctr4, nDctr5, nDctr6,
        dctr1, dctr2, dctr3, dctr4);

    investigadorRepo.saveAll(investigadores);
  }

  private static void imprime(List datos) {

    for (Object dato : datos) {
      log(dato.toString());
    }
    log("");
  }



  /* 4.
  (20%) Para cada investigador no doctor, mostrar su nombre y apellidos junto con el número de becas que ha percibido y la suma de dinero percibida.
  Ojo, los que no tienen beca deben aparecer. Una manera de resolverlo es usando una unión.
  SELECT i.nombre,
          i.apellido,
          count(b.id) as 'becas',
          sum(b.cantidad) as 'dinero'
  FROM test.investigador i,
      test.beca b,
      test.beca_becado bb
  WHERE dtype = 'NoDoctor'
      AND i.id = bb.becado_id
      AND b.id = bb.beca_id
  GROUP BY (i.id)
  UNION
  SELECT i2.nombre,
          i2.apellido ,
          0 as 'becas',
          0 as 'dinero'
  FROM test.investigador i2
  WHERE i2.id NOT IN (SELECT bb2.becado_id FROM test.beca_becado bb2)
  GROUP BY (i2.id)
  ;
   */
}
