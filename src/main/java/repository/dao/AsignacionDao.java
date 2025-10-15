package repository.dao;

import entities.Asignacion;
import jakarta.persistence.EntityManager;
import repository.IAsignacion;
import java.util.List;

public class AsignacionDao implements IAsignacion {
    private final EntityManager em;
    public AsignacionDao(EntityManager em) { this.em = em; }

    @Override
    public Asignacion guardar(Asignacion asignacion) {
        em.getTransaction().begin();
        if (asignacion.getId() == 0L) em.persist(asignacion);
        else asignacion = em.merge(asignacion);
        em.getTransaction().commit();
        return asignacion;
    }

    @Override
    public Asignacion buscarPorId(long id) {
        return em.find(Asignacion.class, id);
    }

    @Override
    public List<Asignacion> listar() {
        return em.createQuery("from Asignacion", Asignacion.class).getResultList();
    }

    @Override
    public void eliminar(long id) {
        em.getTransaction().begin();
        Asignacion a = em.find(Asignacion.class, id);
        if (a != null) em.remove(a);
        em.getTransaction().commit();
    }
}
