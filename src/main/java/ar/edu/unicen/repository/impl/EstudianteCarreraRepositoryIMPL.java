package ar.edu.unicen.repository.impl;

import ar.edu.unicen.dto.Reporte;
import ar.edu.unicen.entity.Carrera;
import ar.edu.unicen.entity.Estudiante;
import ar.edu.unicen.entity.EstudianteCarrera;
import ar.edu.unicen.factory.JPAUtils;
import ar.edu.unicen.repository.EstudianteCarreraRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EstudianteCarreraRepositoryIMPL implements EstudianteCarreraRepository {

    @Override
    public void create(int id, int id_estudiante, int id_carrera,int inscripcion,int graduacion, int antiguedad) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class, id_estudiante);
        Carrera c = em.find(Carrera.class, id_carrera);
        if (e != null && c != null) {
            EstudianteCarrera ec = new EstudianteCarrera(id,e, c, inscripcion, graduacion, antiguedad);
            em.persist(ec);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void update(EstudianteCarrera estudianteCarrera) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(estudianteCarrera);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        EstudianteCarrera ec = em.find(EstudianteCarrera.class, id);
        if (ec != null) {
            em.remove(ec);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Reporte> getAllEstudiantesCarreraByResidencia(int id_carrera, String residencia) {
        EntityManager em = JPAUtils.getEntityManager();
        Carrera c = em.find(Carrera.class, id_carrera);
        if (c != null) {
            String jpql = "SELECT " +
                         "new ar.edu.unicen.dto.Reporte(e.nombre, c.nombre, ec.inscripcion, ec.graduacion, ec.antiguedad, e.ciudad) " +
                         "FROM EstudianteCarrera ec " +
                         "JOIN ec.carrera c " +
                         "JOIN ec.estudiante e " +
                         "WHERE c.id = :id_carrera AND e.ciudad = :residencia ";

            return em.createQuery(jpql, Reporte.class)
                    .setParameter("id_carrera",id_carrera)
                    .setParameter("residencia",residencia)
                    .getResultList();
        }
        System.out.println("No se encontro resultado");
        return null;
    }

    @Override
    public List<Reporte> getEstudiantesInscriptos() {
        EntityManager em = JPAUtils.getEntityManager();
            String jpql = "SELECT new ar.edu.unicen.dto.Reporte(c.nombre,COUNT(e)) " +
                    "FROM EstudianteCarrera ec " +
                    "JOIN ec.estudiante e " +
                    "JOIN ec.carrera c "+
                    "GROUP BY c " +
                    "ORDER BY COUNT(e) DESC";
            return em.createQuery(jpql, Reporte.class)
                    .getResultList();
    }

    public List<Reporte> getReportes() {
        EntityManager em = JPAUtils.getEntityManager();
        String jpql =  "SELECT new ar.edu.unicen.dto.Reporte(" +
                "c.nombre, " +
                "ec.inscripcion, " +
                "COUNT(ec), " +
                "SUM(CASE WHEN ec.graduacion > 0 THEN 1 ELSE 0 END)) " +
                "FROM EstudianteCarrera ec " +
                "JOIN ec.carrera c " +
                "GROUP BY c.nombre, ec.inscripcion " +
                "ORDER BY c.nombre ASC, ec.inscripcion ASC";
        return em.createQuery(jpql, Reporte.class).getResultList();
    }

}
