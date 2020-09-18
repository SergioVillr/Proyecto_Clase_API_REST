package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.tramites.entities.TramitesRegistrados;
import org.una.tramites.entities.Usuario;

/**
 *
 * @author Sergio
 */
public interface ITramitesRegistradosRepository extends JpaRepository<TramitesRegistrados, Long>{
    
    //@Query("SELECT t FROM TramitesRegistrados t LEFT JOIN t.cliente d WHERE t.cliente.id =:id")
    //public List<TramitesRegistrados> findByClienteId(Long id);
    public List<TramitesRegistrados> findByTramiteTipoId(Long id);
}
