package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.una.tramites.entities.Variacion;

/**
 *
 * @author chris
 */
@Service
public interface IVariacionRepository extends JpaRepository<Variacion, Long> {

    @Override
    public Optional<Variacion> findById(Long id);

    public Optional<List<Variacion>> findByTramiteTipoId(Long tramiteTipoId);

    public Optional<List<Variacion>> findByTramiteTipoIdAndEstado(Long tramiteTipoId, boolean estado);

    public Optional<List<Variacion>> findByFechaRegistroBetween(Date startDate, Date endDate);

}
