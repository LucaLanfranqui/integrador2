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
public class Carrera {
    @Id
    private int id;
    @Column(unique = true)
    private String nombre;
    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> inscriptos;
}
