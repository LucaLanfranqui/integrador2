package ar.edu.unicen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Estudiante {
    @Id
    @Column(name = "dni")
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int numeroLibreta;
    @OneToMany(mappedBy = "alumnos")
        private List<EstudianteCarrera> inscripciones;
}
