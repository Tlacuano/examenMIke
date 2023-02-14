package mx.edu.utez.appSpring.controller.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;
import mx.edu.utez.appSpring.model.usuario.Usuario;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UsuarioDto {


    private Long id;

    private String nombre;

    private String correo;

    private String contrasena;

    private String listaDeceos;


    private List<Transaccion> transacciones;

    public Usuario getUsuario(
    ){
        return new Usuario(
                getId(),
                getNombre(),
                getCorreo(),
                getContrasena(),
                getListaDeceos(),
                getTransacciones()
        );

    }

}
