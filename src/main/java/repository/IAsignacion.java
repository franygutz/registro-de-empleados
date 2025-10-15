// repository/IAsignacion.java
package repository;

import entities.Asignacion;
import java.util.List;

public interface IAsignacion {
    Asignacion guardar(Asignacion asignacion);
    Asignacion buscarPorId(long id);
    List<Asignacion> listar();
    void eliminar(long id);
}
