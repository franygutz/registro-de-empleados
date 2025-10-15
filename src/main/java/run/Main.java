package run;

import config.JPAUtil;
import entities.Empleado;
import entities.Cargo;
import entities.Asignacion;
import jakarta.persistence.EntityManager;
import repository.dao.EmpleadoDao;
import repository.dao.CargoDao;
import repository.dao.AsignacionDao;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        var empDao  = new EmpleadoDao(em);
        var carDao  = new CargoDao(em);
        var asgDao  = new AsignacionDao(em);

        Empleado emp = new Empleado();
        emp.setCedula("001-280807-2011A");// no nulo y unico
        emp.setNombres("Franya");//no nulo
        emp.setApellidos("Gutierrez");//no nulo
        emp.setEmail("aaaa@uamv.edu.ni");//no nulo
        emp.setTelefono("9911222");//no nulo
        emp.setActivo(true);//puede ser nullo
        emp = empDao.guardar(emp);

        Cargo car = new Cargo();
        car.setNombre("Mercadologo");//no nulo
        car.setDescripcion("Dev Java");//puede ser nulo
        car = carDao.guardar(car);

        Asignacion asg = new Asignacion();
        asg.setEmpleado(emp);
        asg.setCargo(car);
        asg.setFechaInicio(LocalDate.now());
        asg = asgDao.guardar(asg);

        em.close();
    }
}
