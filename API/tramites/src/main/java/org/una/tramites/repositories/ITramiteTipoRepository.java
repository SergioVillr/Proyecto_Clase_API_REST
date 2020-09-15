package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author chris
 */
@Service
public interface ITramiteTipoRepository extends JpaRepository<TramiteTipo, Long> {

    @Override
    public Optional<TramiteTipo> findById(Long id);

    public Optional<List<TramiteTipo>> findByDepartamentoId(Long departamentoId);

    public Optional<List<TramiteTipo>> findByEstado(boolean estado);

    public Optional<List<TramiteTipo>> findByFechaRegistroBetween(Date startDate, Date endDate);

}
