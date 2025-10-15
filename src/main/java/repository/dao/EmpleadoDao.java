package repository.dao;

import entities.Empleado;
import jakarta.persistence.EntityManager;
import repository.IEmpleado;
import java.util.List;

public class EmpleadoDao implements IEmpleado {
    private final EntityManager em;
    public EmpleadoDao(EntityManager em) { this.em = em; }

    @Override
    public Empleado guardar(Empleado empleado) {
        em.getTransaction().begin();
        if (empleado.getId() == 0L) em.persist(empleado);   // long: 0 => nuevo
        else empleado = em.merge(empleado);
        em.getTransaction().commit();
        return empleado;
    }

    @Override
    public Empleado buscarPorId(long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> listar() {
        return em.createQuery("from Empleado", Empleado.class).getResultList();
    }

    @Override
    public void eliminar(long id) {
        em.getTransaction().begin();
        Empleado e = em.find(Empleado.class, id);
        if (e != null) em.remove(e);
        em.getTransaction().commit();
    }
}
