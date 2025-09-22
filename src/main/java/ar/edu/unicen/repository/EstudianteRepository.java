package ar.edu.unicen.repository;

import ar.edu.unicen.entity.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    void create(Estudiante estudiante);
    void update(Estudiante estudiante);
    void delete(Estudiante estudiante);
    Estudiante findById(int id);
    List<Estudiante> findAll();

}
