package org.una.tramites.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.TramitesCambiosEstados;
/*
 *
 *
 * @author Sergio
 */
public interface ITramitesCambiosEstadosRepository extends JpaRepository<TramitesCambiosEstados, Long> {

    public Optional<List<TramitesCambiosEstados>> findByUsuarioId(Long id);

    public Optional<List<TramitesCambiosEstados>> findByTramitesRegistradosId(Long id);

    public Optional<List<TramitesCambiosEstados>> findByTramitesEstadosId(Long id);

}
