package ar.edu.unicen.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    private String nombre;
    private String nombreCarrera;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
}
