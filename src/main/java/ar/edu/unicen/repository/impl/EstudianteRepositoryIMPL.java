package ar.edu.unicen.repository.impl;

import ar.edu.unicen.dto.CarreraDTO;
import ar.edu.unicen.dto.EstudianteDTO;
import ar.edu.unicen.entity.Carrera;
import ar.edu.unicen.entity.Estudiante;
import ar.edu.unicen.factory.JPAUtils;
import ar.edu.unicen.repository.EstudianteRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EstudianteRepositoryIMPL implements EstudianteRepository {

    @Override
    public void create(Estudiante estudiante) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Estudiante estudiante) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(estudiante);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class, id);
        em.remove(e);
        em.getTransaction().commit();
    }

    @Override
    public EstudianteDTO findById(int id) {
        EntityManager em = JPAUtils.getEntityManager();
        Carrera carrera = em.find(Carrera.class, id);
        if (carrera != null) {
            String jpql = "SELECT new ar.edu.unicen.dto.EstudianteDTO(e.dni,CONCAT(e.nombre, e.apellido), e.genero, e.ciudad, e.numeroLibreta ) FROM Estudiante e WHERE e.dni = :id";
            return em.createQuery(jpql,  EstudianteDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        return null;
    }

    @Override
    public List<EstudianteDTO> findAll() {
        return List.of();
    }
}
