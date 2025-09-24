package ar.edu.unicen.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class EstudianteCarrera {
    @Id
    private int id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "dni")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private Carrera carrera;

    private int inscripcion;
    private int graduacion;
    private int antiguedad;

}
