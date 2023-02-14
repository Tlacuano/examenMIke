package mx.edu.utez.appSpring.controller.transaccion;


import mx.edu.utez.appSpring.controller.transaccion.dtos.TransaccionDto;
import mx.edu.utez.appSpring.controller.usuario.dtos.UsuarioDto;
import mx.edu.utez.appSpring.model.transaccione.Transaccion;
import mx.edu.utez.appSpring.model.usuario.Usuario;
import mx.edu.utez.appSpring.service.transaccion.TransaccionService;
import mx.edu.utez.appSpring.service.usuario.UsuarioService;
import mx.edu.utez.appSpring.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-appSpring/transaccion")
@CrossOrigin(origins = {"*"})
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    //get ALl
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Transaccion>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //getOne
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Transaccion>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //insert
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Transaccion>> insert(@Valid @RequestBody TransaccionDto transaccionDto){
        return new ResponseEntity<> (
                this.service.insert(transaccionDto.getTransaccion()),
                HttpStatus.CREATED
        );
    }

    //update
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Transaccion>> update(@PathVariable Long id, @Valid @RequestBody TransaccionDto transaccionDto){
        return new ResponseEntity<>(
                this.service.update(id, transaccionDto.getTransaccion()),
                HttpStatus.OK
        );
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Transaccion>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
