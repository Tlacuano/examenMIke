package mx.edu.utez.appSpring.service.usuario;

import mx.edu.utez.appSpring.model.producto.Producto;
import mx.edu.utez.appSpring.model.producto.ProductoRepository;
import mx.edu.utez.appSpring.model.usuario.Usuario;
import mx.edu.utez.appSpring.model.usuario.UsuarioRepository;
import mx.edu.utez.appSpring.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository Repository;
    //getAll
    @Transactional(readOnly = true)
    public CustomResponse<List<Usuario>> getAll(){
        return new CustomResponse<>(
                this.Repository.findAll(),false,200,"ok"
        );
    }
    //getOne
    @Transactional(readOnly = true)
    public CustomResponse<Usuario> getOne(Long id){
        return new CustomResponse<>(
                this.Repository.findById(id).get(),false,200,"ok"
        );
    }

    //insert
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario> insert(Usuario usuario){
        if(this.Repository.existsUsuarioByNombre(usuario.getNombre())){
            return new CustomResponse<>(null,true,400,"ya existe");
        }
        return new CustomResponse<>(
                this.Repository.saveAndFlush(usuario),false,200,"ok"
        );
    }

    //update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario> update(Long id,Usuario usuario){
        if((!this.Repository.existsById(id))){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        return new CustomResponse<>(
                this.Repository.saveAndFlush(usuario),false,200,"ok"
        );
    }

    //delate
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario> delete(Long id){
        Optional<Usuario> exists = this.Repository.findById(id);

        if((!exists.isPresent())){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        this.Repository.deleteById(id);
        return new CustomResponse<>(
                null,false,200,"ok"
        );
    }
}
