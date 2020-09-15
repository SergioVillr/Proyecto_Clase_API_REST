package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.una.tramites.entities.Requisito;

/**
 *
 * @author chris
 */
@Service
public interface IRequisitoRepository extends JpaRepository<Requisito, Long> {

    @Override
    public Optional<Requisito> findById(Long id);

    public Optional<List<Requisito>> findByVariacionId(Long variacionId);

    public Optional<List<Requisito>> findByEstado(boolean estado);

    public Optional<List<Requisito>> findByFechaRegistroBetween(Date startDate, Date endDate);

}
