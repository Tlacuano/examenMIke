package mx.edu.utez.appSpring.controller.transaccion.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;
import mx.edu.utez.appSpring.model.usuario.Usuario;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransaccionDto {


    private Long id;


    private Usuario usuario;

    private Producto producto;
    private Date fecha;
    public Transaccion getTransaccion() {
        return new Transaccion(
                getId(),
                getUsuario(),
                getProducto(),
                getFecha()
        );
    }
}
