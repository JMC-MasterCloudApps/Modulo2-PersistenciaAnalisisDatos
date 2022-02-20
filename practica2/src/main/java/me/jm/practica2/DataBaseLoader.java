package me.jm.practica2;

import static java.time.LocalDate.of;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.jm.practica2.dto.Asistente;
import me.jm.practica2.dto.AsistenteCongreso;
import me.jm.practica2.dto.AsistentesPorUniversidad;
import me.jm.practica2.dto.BecasNoDoctor;
import me.jm.practica2.dto.InfoBecas;
import me.jm.practica2.dto.InvestigadoresPorUni;
import me.jm.practica2.dto.RepresentacionUniversidad;
import me.jm.practica2.entity.Beca;
import me.jm.practica2.entity.BecaBecado;
import me.jm.practica2.entity.Congreso;
import me.jm.practica2.entity.CongresoAsistente;
import me.jm.practica2.entity.Doctor;
import me.jm.practica2.entity.Investigador;
import me.jm.practica2.entity.NoDoctor;
import me.jm.practica2.entity.Universidad;
import me.jm.practica2.repository.BecaRepository;
import me.jm.practica2.repository.CongresoRepository;
import me.jm.practica2.repository.InvestigadorRepository;
import me.jm.practica2.repository.UniversidadRepository;
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

  private static final String NOMBRE_CONGRESO = "Amigos de las matemáticas";

  public static void log(String message) {
    System.out.println(message);
  }

  @Override
  public void run(String... args) {

    //creaDatos();

    List<Investigador> investigadoresAll = investigadorRepo.findAllBy();
    log("________________________________\nInvestigadores  findAll");
    imprime(investigadoresAll);

    investigadoresPorUniversidad();
    asistentesACongreso(NOMBRE_CONGRESO);
    asistentesCongresoPorUniversidad(NOMBRE_CONGRESO);
    becarios();
  }

  private static void imprime(List datos) {

    for (Object dato : datos) {
      log(dato.toString());
    }
    log("");
  }

  private void creaDatos() {
    log("________________________________\nCreando universidades...");
    var ugr = new Universidad("Universidad de Granada", "Granada", "España");
    var upm = new Universidad("Universidad Politécnica de Madrid", "Madrid", "España");
    var lut = new Universidad("Lappeenranta University of Technology", "Lappeenranta", "Finlandia");

    uniRepo.saveAll(List.of(ugr, upm, lut));

    log("________________________________\nCreando becas, congresos e investigadores");
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


    var beca1 = new Beca("Beca Ramón y Cajal", 18500);
    var beca2 = new Beca("Stephen Hawking", 85500);
    var beca3 = new Beca("Fundación amigos de Donatello", 25100);

    nDctr1.setBecas(List.of(new BecaBecado(beca1, nDctr1)));
    nDctr2.setBecas(List.of(new BecaBecado(beca1, nDctr2), new BecaBecado(beca2, nDctr2)));
    nDctr5.setBecas(List.of(new BecaBecado(beca2, nDctr5), new BecaBecado(beca3, nDctr5)));

    List<Investigador> investigadores = List.of(
        nDctr1, nDctr2, nDctr3, nDctr4, nDctr5, nDctr6,
        dctr1, dctr2, dctr3, dctr4);

    var cngrs1 = new Congreso(NOMBRE_CONGRESO, "Cáceres", "España", of(2022, 3, 15), of(2022, 3, 17));
    var cngrs2 = new Congreso("Thunderbolt congress", "Helsinki", "Finland", of(2022, 5, 1), of(2022, 5, 7));
    var cngrs3 = new Congreso("WWW congress", "Las Vegas", "USA", of(2022, 11, 17), of(2022, 11, 23));

    nDctr1.setCongresos(List.of(new CongresoAsistente(cngrs1, nDctr1)));
    nDctr2.setCongresos(List.of(new CongresoAsistente(cngrs1, nDctr2), new CongresoAsistente(cngrs2, nDctr2)));
    dctr1.setCongresos(List.of(new CongresoAsistente(cngrs1, dctr1), new CongresoAsistente(cngrs2, dctr1)));
    dctr2.setCongresos(List.of(new CongresoAsistente(cngrs1, dctr2)));
    dctr3.setCongresos(List.of(new CongresoAsistente(cngrs1, dctr3), new CongresoAsistente(cngrs2, dctr3), new CongresoAsistente(cngrs3, dctr3)));

    investigadorRepo.saveAll(investigadores);
  }

  private void investigadoresPorUniversidad() {
    List<InvestigadoresPorUni> investigadoresPorUnis = investigadorRepo.findAllWithTypeAndUniversity();
    log("________________________________\nInvestigadores ordenados por universidad: ");
    imprime(investigadoresPorUnis.stream().map(InvestigadoresPorUni::getInvestigadorUniversidad).toList());
  }

  private void asistentesACongreso(String congreso) {
    List<Asistente> asistentesCongreso = congresoRepo.findAsistentesByNombre(congreso);
    log("________________________________\nAsistentes a congreso '" + congreso + "':");
    imprime(asistentesCongreso.stream().map(AsistenteCongreso::build).toList());
  }

  private void asistentesCongresoPorUniversidad(String congreso) {
    List<RepresentacionUniversidad> asistentesCongreso = congresoRepo.findAsistentesPorUniversidad(congreso);
    log("________________________________\nAsistentes por universidad al congreso '" + congreso + "':");
    imprime(asistentesCongreso.stream().map(AsistentesPorUniversidad::build).toList());
  }

  private void becarios() {
    List<InfoBecas> becarios = investigadorRepo.findBecasNoDoctores();
    log("________________________________\nBecario, becas, dinero");
    imprime(becarios.stream().map(BecasNoDoctor::build).toList());
  }

}
