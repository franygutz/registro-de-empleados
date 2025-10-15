package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargos")
@Getter @Setter
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre", length=50, nullable = false)
    private String nombre;

    @Column(name="descripcion", length=100)
    private String descripcion;

}
