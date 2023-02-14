package mx.edu.utez.appSpring.service.transaccion;


import mx.edu.utez.appSpring.model.transaccione.Transaccion;
import mx.edu.utez.appSpring.model.transaccione.TransaccionRespository;
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
public class TransaccionService {
    @Autowired
    private TransaccionRespository Repository;

    //getAll
    @Transactional(readOnly = true)
    public CustomResponse<List<Transaccion>> getAll(){
        return new CustomResponse<>(
                this.Repository.findAll(),false,200,"ok"
        );
    }
    //getOne
    @Transactional(readOnly = true)
    public CustomResponse<Transaccion> getOne(Long id){
        return new CustomResponse<>(
                this.Repository.findById(id).get(),false,200,"ok"
        );
    }

    //insert
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Transaccion> insert(Transaccion transaccion){

        return new CustomResponse<>(
                this.Repository.saveAndFlush(transaccion),false,200,"ok"
        );
    }

    //update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Transaccion> update(Long id,Transaccion usuario){
        if((!this.Repository.existsById(id))){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        return new CustomResponse<>(
                this.Repository.saveAndFlush(usuario),false,200,"ok"
        );
    }

    //delate
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Transaccion> delete(Long id){
        Optional<Transaccion> exists = this.Repository.findById(id);

        if((!exists.isPresent())){
            return new CustomResponse<>(null,true,400,"no existe");
        }
        this.Repository.deleteById(id);
        return new CustomResponse<>(
                null,false,200,"ok"
        );
    }
}
