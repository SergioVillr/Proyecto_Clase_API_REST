package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.una.tramites.entities.Permiso;
/**
 *
 * @author Sergio
 */
@Service
public interface IPermisoRepository extends JpaRepository<Permiso, Long> {

    @Override
    public Optional<Permiso> findById(Long id);

    public Optional<List<Permiso>> findByEstado(boolean estado);

    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public Optional<Permiso> findByCodigo(String codigo);
    
    public Long countByEstado(boolean estado);
}
