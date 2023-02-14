package mx.edu.utez.appSpring.service.producto;

import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.model.producto.ProductoRepository;
import mx.edu.utez.appSpring.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository Repository;

    //getAll
    @Transactional(readOnly = true)
    public CustomResponse<List<Producto>> getAll(){
        return new CustomResponse<>(
                this.Repository.findAll(),false,200,"ok"
        );
    }
    //getOne
    @Transactional(readOnly = true)
    public CustomResponse<Producto> getOne(Long id){
        return new CustomResponse<>(
                this.Repository.findById(id).get(),false,200,"ok"
        );
    }

    //insert
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto> insert(Producto producto){
        if(this.Repository.existsProductoByNombre(producto.getNombre())){
            return new CustomResponse<>(null,true,400,"ya existe");
        }
        return new CustomResponse<>(
                this.Repository.saveAndFlush(producto),false,200,"ok"
        );
    }

    //update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto> update(Long id,Producto producto){
        if((!this.Repository.existsById(id))){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        return new CustomResponse<>(
                this.Repository.saveAndFlush(producto),false,200,"ok"
        );
    }

    //delate
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto> delete(Long id){
        Optional<Producto> exists = this.Repository.findById(id);

        if((!exists.isPresent())){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        this.Repository.deleteById(id);
        return new CustomResponse<>(
                null,false,200,"ok"
        );
    }

}
