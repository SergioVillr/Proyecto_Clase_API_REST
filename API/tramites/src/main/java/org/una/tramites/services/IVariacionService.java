
package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Variacion;


public interface IVariacionService {

    public Optional<Variacion> findById(Long id);

    public Optional<List<Variacion>> findByTramiteTipoId(Long tramiteTipoId);

    public Optional<List<Variacion>> findByTramiteTipoIdAndEstado(Long tramiteTipoId, boolean estado);

    public Optional<List<Variacion>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public Variacion create(Variacion variacion);

    public Optional<Variacion> update(Variacion variacion, Long id);

    public void delete(Long id);

    public void deleteAll();

}
