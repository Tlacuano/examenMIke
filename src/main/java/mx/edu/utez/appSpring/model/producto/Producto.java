package mx.edu.utez.appSpring.model.producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "productos")
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombreProducto", nullable = false, length = 50)
    private String nombre;
    @Column(name="categoriaProducto", nullable = false, length = 50)
    private String categoria;
    @Column(name="precioProducto", nullable = false)
    private double precio;
    @Column(name="disponibilidadProducto", nullable = false)
    private Boolean disponibilidad;

    @OneToMany(mappedBy = "producto")
    private List<Transaccion> transacciones;

    public Producto(Long id, String nombre, String categoria, double precio, Boolean disponibilidad, List<Transaccion> transacciones) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.transacciones = transacciones;
    }
}
