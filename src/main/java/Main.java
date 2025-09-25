import ar.edu.unicen.utils.CargarDatos;

import java.sql.SQLException;

void main() throws IOException, SQLException {
//  CargarDatos.run();
  CargarDatos.getEstudiantesInscriptos().forEach(System.out::println);
//  CargarDatos.getReportes().forEach(System.out::println);
//  CargarDatos.getAllEstudiantesCarreraByResidencia(1,"Tandil").forEach(System.out::println);
//  CargarDatos.findBylibreta(13413);
}
