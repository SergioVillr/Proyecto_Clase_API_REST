package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.tramites.entities.RequisitoPresentado;

/**
 *
 * @author Sergio
 */
public interface IRequisitoPresentadoRepository extends JpaRepository<RequisitoPresentado, Long> {

    @Query("SELECT a FROM RequisitoPresentado a LEFT JOIN a.tramitesRegistrados t WHERE a.tramitesRegistrados.id =:id")
    
    public List<RequisitoPresentado> findByRequisito(Long id);

    public List<RequisitoPresentado> findByTramitesRegistrados(Long id);

}
