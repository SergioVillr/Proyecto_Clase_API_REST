package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.TramitesEstados;

/**
 *
 * @author Sergio
 */
public interface ITramitesEstadosRepository extends JpaRepository<TramitesEstados, Long>{
    
}
