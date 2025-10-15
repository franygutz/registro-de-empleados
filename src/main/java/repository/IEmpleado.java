package repository;

import entities.Empleado;
import java.util.List;

public interface IEmpleado {
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(long id);
    List<Empleado> listar();
    void eliminar(long id);
}
