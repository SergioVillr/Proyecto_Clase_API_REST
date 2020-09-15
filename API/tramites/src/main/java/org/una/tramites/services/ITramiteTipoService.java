
package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.TramiteTipo;


public interface ITramiteTipoService {

    public Optional<TramiteTipo> findById(Long id);

    public Optional<List<TramiteTipo>> findByDepartamentoId(Long departamentoId);

    public Optional<List<TramiteTipo>> findByEstado(boolean estado);

    public Optional<List<TramiteTipo>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public TramiteTipo create(TramiteTipo tramiteTipo);

    public Optional<TramiteTipo> update(TramiteTipo tramiteTipo, Long id);

    public void delete(Long id);

    public void deleteAll();

}
