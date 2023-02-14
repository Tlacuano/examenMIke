package mx.edu.utez.appSpring.controller.usuario;

import mx.edu.utez.appSpring.controller.producto.dtos.ProductoDto;
import mx.edu.utez.appSpring.controller.usuario.dtos.UsuarioDto;
import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.model.usuario.Usuario;
import mx.edu.utez.appSpring.service.producto.ProductoService;
import mx.edu.utez.appSpring.service.usuario.UsuarioService;
import mx.edu.utez.appSpring.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-appSpring/usuario")
@CrossOrigin(origins = {"*"})
public class UsurioController {
    @Autowired
    private UsuarioService service;

    //get ALl
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Usuario>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //getOne
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //insert
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Usuario>> insert(@Valid @RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<> (
                this.service.insert(usuarioDto.getUsuario()),
                HttpStatus.CREATED
        );
    }

    //update
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> update(@PathVariable Long id, @Valid @RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(
                this.service.update(id, usuarioDto.getUsuario()),
                HttpStatus.OK
        );
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
