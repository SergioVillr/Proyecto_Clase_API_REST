package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Permiso;
/**
 *
 * @author Sergio
 */
public interface IPermisoService {

    public Optional<Permiso> findById(Long id);

    public Optional<List<Permiso>> findByEstado(boolean estado);

    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public Permiso create(Permiso permiso);

    public Optional<Permiso> update(Permiso permiso, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<Permiso> findByCodigo(String codigo);
    
    public Long countByEstado(boolean estado);

}

