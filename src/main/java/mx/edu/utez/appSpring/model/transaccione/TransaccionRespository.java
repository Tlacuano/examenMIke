package mx.edu.utez.appSpring.model.transaccione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRespository extends JpaRepository<Transaccion,Long> {

}
