import ar.edu.unicen.utils.CargarDatos;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //CargarDatos.run();
        //CargarDatos.getEstudiantesInscriptos().forEach(System.out::println);
        CargarDatos.getReportes().forEach(System.out::println);
        //CargarDatos.getAllEstudiantesCarreraByResidencia(1,"Tandil").forEach(System.out::println);
        //CargarDatos.findBylibreta(13413);
    }
}
