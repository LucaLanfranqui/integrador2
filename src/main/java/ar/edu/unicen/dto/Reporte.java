package ar.edu.unicen.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor

public class Reporte {
    private String nombre;
    private String nombreCarrera;
    private int inscripcion; //es un anio
    private int graduacion;
    private int antiguedad;
    private String residencia;
    private int egresados;
    private Long cantidadDeInscriptos;

    public Reporte(String nombre, String nombreCarrera, int inscripcion, int graduacion, int antiguedad, String residencia){
        this.nombre = nombre;
        this.nombreCarrera = nombreCarrera;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
        this.residencia = residencia;
    }

    public Reporte(String nombreCarrera, int inscripcion, Long cantidadDeInscriptos, Long egresados){
        this.nombreCarrera = nombreCarrera;
        this.inscripcion = inscripcion;
        this.cantidadDeInscriptos = cantidadDeInscriptos;
        this.egresados = egresados.intValue();
    }

    public Reporte(String nombreCarrera, Long cantidadDeInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadDeInscriptos = cantidadDeInscriptos;
    }
}
