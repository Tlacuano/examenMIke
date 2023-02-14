package mx.edu.utez.appSpring.controller.producto;

import mx.edu.utez.appSpring.controller.producto.dtos.ProductoDto;
import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.service.producto.ProductoService;
import mx.edu.utez.appSpring.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-appSpring/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController {
    @Autowired
    private ProductoService service;


    //get ALl
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Producto>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //getOne
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Producto>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //insert
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Producto>> insert(@Valid @RequestBody ProductoDto producto){
        return new ResponseEntity<> (
                this.service.insert(producto.getProducto()),
                HttpStatus.CREATED
        );
    }

    //update
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Producto>> update(@PathVariable Long id, @Valid @RequestBody ProductoDto producto){
        return new ResponseEntity<>(
                this.service.update(id, producto.getProducto()),
                HttpStatus.OK
        );
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Producto>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
