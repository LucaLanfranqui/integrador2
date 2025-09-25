package ar.edu.unicen.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor

public class Reporte {
    private String nombre;
    private String nombreCarrera;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
    private Long cantidadDeInscriptos;

    public Reporte(String nombre, String nombreCarrera, int inscripcion, int graduacion, int antiguedad) {
        this.nombre = nombre;
        this.nombreCarrera = nombreCarrera;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }
    public Reporte(String nombreCarrera, Long cantidadDeInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadDeInscriptos = cantidadDeInscriptos;
    }
}
