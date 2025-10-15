package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "asignaciones")
@Getter @Setter
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //quien se asigna
    @ManyToOne(optional = false)
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    //a qué cargo
    @ManyToOne(optional = false)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    //desde y hasta
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
