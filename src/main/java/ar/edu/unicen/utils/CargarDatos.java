package ar.edu.unicen.utils;

import ar.edu.unicen.dto.EstudianteDTO;
import ar.edu.unicen.dto.Reporte;
import ar.edu.unicen.entity.Carrera;
import ar.edu.unicen.entity.Estudiante;
import ar.edu.unicen.entity.EstudianteCarrera;
import ar.edu.unicen.repository.impl.CarreraRepositoryIMPL;
import ar.edu.unicen.repository.impl.EstudianteCarreraRepositoryIMPL;
import ar.edu.unicen.repository.impl.EstudianteRepositoryIMPL;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CargarDatos {
        private static CarreraRepositoryIMPL carrerarepositoryimpl;
        private static EstudianteRepositoryIMPL estudianterepositoryimpl;
        private static EstudianteCarreraRepositoryIMPL estudiantecarrerarepositoryimpl;



        static{
            carrerarepositoryimpl = new CarreraRepositoryIMPL();
            estudianterepositoryimpl = new EstudianteRepositoryIMPL();
            estudiantecarrerarepositoryimpl = new EstudianteCarreraRepositoryIMPL();
        }
        public static void run() throws SQLException, IOException {
            aniadirDatos();
        }


        //añade los datos de los CSV a cada tabla
        private static void aniadirDatos() throws SQLException, IOException {
            cargarEstudiantes("src/main/resources/data/estudiantes.csv");
            cargarCarreras("src/main/resources/data/carreras.csv");
            cargarEstudianteCarrera("src/main/resources/data/estudianteCarrera.csv");
        }


        //carga los datos del csv Estudiante.csv a la tabla estudiante
        private static void cargarEstudiantes(String CSV) throws SQLException, IOException {
            CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(CSV));
            for(CSVRecord row: parser) {
                Estudiante e1 = new Estudiante(Integer.valueOf(row.get("DNI")), row.get("nombre"), row.get("apellido"),Integer.valueOf(row.get("edad")), row.get("genero"), row.get("ciudad"),Integer.valueOf(row.get("LU")));
                estudianterepositoryimpl.create(e1);
            }
        }

        //carga los datos del csv Estudiante.csv a la tabla estudiante
        private static void cargarCarreras(String CSV) throws SQLException, IOException {
            CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(CSV));
            for(CSVRecord row: parser) {
                Carrera c1 = new Carrera(Integer.valueOf(row.get("id_carrera")),row.get("carrera"),Integer.valueOf(row.get("id_carrera")));
                carrerarepositoryimpl.create(c1);
            }
        }

        //carga los datos del csv facturas.csv a la tabla factura
        private static void cargarEstudianteCarrera(String CSV) throws SQLException, IOException{
            CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(CSV));

            for(CSVRecord row: parser) {
                estudiantecarrerarepositoryimpl.create(Integer.valueOf(row.get("id")),Integer.valueOf(row.get("id_estudiante")),Integer.valueOf(row.get("id_carrera")),Integer.valueOf(row.get("inscripcion")),Integer.valueOf(row.get("graduacion")),Integer.valueOf(row.get("antiguedad")));
            }
        }
        public static List<Reporte> getAllEstudiantesCarreraByResidencia(int carrera, String residencia) throws SQLException, IOException{
            return estudiantecarrerarepositoryimpl.getAllEstudiantesCarreraByResidencia(carrera,residencia);
        }
        public static List<Reporte> getEstudiantesInscriptos(){
            return estudiantecarrerarepositoryimpl.getEstudiantesInscriptos();
        }
        public static List<Reporte> getReportes(){
            return estudiantecarrerarepositoryimpl.getReportes();
        }
        public static EstudianteDTO findBylibreta(int libreta){
            return estudianterepositoryimpl.findByLibreta(libreta);
        }
}
