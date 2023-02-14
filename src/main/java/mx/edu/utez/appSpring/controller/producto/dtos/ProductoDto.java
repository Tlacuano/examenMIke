package mx.edu.utez.appSpring.controller.producto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductoDto {


    private Long id;
    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    @Size(min = 3, max = 50)
    private String nombre;

    private String categoria;

    private double precio;

    private Boolean disponibilidad;

    private List<Transaccion> transacciones;

    public Producto getProducto(){
        return new Producto(
            getId(),
                getNombre(),
                getCategoria(),
                getPrecio(),
                getDisponibilidad(),
                getTransacciones()
        );

    }
}
