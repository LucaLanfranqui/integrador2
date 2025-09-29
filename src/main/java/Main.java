import ar.edu.unicen.utils.CargarDatos;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws IOException, SQLException{
    CargarDatos.run();
    CargarDatos.getEstudiantesInscriptos().forEach(System.out::println);
    CargarDatos.getReportes().forEach(System.out::println); //Enunciado 3
    CargarDatos.getAllEstudiantesCarreraByResidencia(1,"Rauch").forEach(System.out::println);
    System.out.println(CargarDatos.findBylibreta(13413));
  }
}

