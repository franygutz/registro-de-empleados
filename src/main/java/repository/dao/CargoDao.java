// repository/dao/CargoDao.java
package repository.dao;

import entities.Cargo;
import jakarta.persistence.EntityManager;
import repository.ICargo;
import java.util.List;

public class CargoDao implements ICargo {
    private final EntityManager em;
    public CargoDao(EntityManager em) { this.em = em; }

    @Override
    public Cargo guardar(Cargo cargo) {
        em.getTransaction().begin();
        if (cargo.getId() == 0L) em.persist(cargo);
        else cargo = em.merge(cargo);
        em.getTransaction().commit();
        return cargo;
    }

    @Override
    public Cargo buscarPorId(long id) {
        return em.find(Cargo.class, id);
    }

    @Override
    public List<Cargo> listar() {
        return em.createQuery("from Cargo", Cargo.class).getResultList();
    }

    @Override
    public void eliminar(long id) {
        em.getTransaction().begin();
        Cargo c = em.find(Cargo.class, id);
        if (c != null) em.remove(c);
        em.getTransaction().commit();
    }
}

