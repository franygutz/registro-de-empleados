package repository;

import entities.Cargo;
import java.util.List;

public interface ICargo {
    Cargo guardar(Cargo cargo);
    Cargo buscarPorId(long id);
    List<Cargo> listar();
    void eliminar(long id);
}
