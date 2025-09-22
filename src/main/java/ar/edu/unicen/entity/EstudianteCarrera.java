package ar.edu.unicen.entity;

import jakarta.persistence.*;

@Entity
public class EstudianteCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @ManyToOne
   @MapsId("id")
   @JoinColumn(name = "dni")
   private Estudiante estudiante;

   @ManyToOne
   @MapsId("id")
   @JoinColumn(name = "id")
   private Carrera carrera;

   private int antiguedad;
   private boolean seGraduo;

}
