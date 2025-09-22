package ar.edu.unicen.repository;

import ar.edu.unicen.entity.Carrera;
import ar.edu.unicen.entity.Estudiante;

import java.util.List;

public interface CarreraRepository {
    void create(Carrera carrera);
    void update(Carrera carrera);
    void delete(int id);
    List<Carrera> findAll();
    Carrera findById(int id);
}
