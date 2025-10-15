package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "empleados")
@Getter @Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="cedula", length=16, nullable = false, unique = true)
    private String cedula;

    @Column(name="nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name="apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name="email", length = 50, nullable = false)
    private String email;

    @Column(name="telefono", length = 8, nullable = false)
    private String telefono;

    @Column(name="activo")
    private boolean activo;
}
