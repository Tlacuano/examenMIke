package mx.edu.utez.appSpring.model.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombreUsuario", nullable = false, length = 90)
    private String nombre;
    @Column(name = "correoUsuario", nullable = false, length = 90)
    private String correo;
    @Column(name = "contrasenaUsuario", nullable = false, length = 90)
    private String contrasena;
    @Column(name = "listaDeceos", nullable = false, length = 90)
    private String listaDeceos;

    @OneToMany(mappedBy = "usuario")
    private List<Transaccion> transacciones;

    public Usuario(Long id, String nombre, String correo, String contrasena, String listaDeceos, List<Transaccion> transacciones) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.listaDeceos = listaDeceos;
        this.transacciones = transacciones;
    }
}
