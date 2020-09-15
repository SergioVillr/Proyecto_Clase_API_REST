package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Variacion;
import org.una.tramites.repositories.IVariacionRepository;

/**
 *
 * @author Heilen
 */
@Service
public class VariacionServiceImplementation implements IVariacionService {

    @Autowired
    private IVariacionRepository variacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Variacion> findById(Long id) {
        return variacionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findByTramiteTipoId(Long tramiteTipoId) {
        return variacionRepository.findByTramiteTipoId(tramiteTipoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findByTramiteTipoIdAndEstado(Long tramiteTipoId, boolean estado) {
        return variacionRepository.findByTramiteTipoIdAndEstado(tramiteTipoId, estado);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return variacionRepository.findByFechaRegistroBetween(startDate, endDate);
    }

    @Override
    @Transactional
    public Variacion create(Variacion variacion) {
        return variacionRepository.save(variacion);
    }

    @Override
    @Transactional
    public Optional<Variacion> update(Variacion variacion, Long id) {
        if (variacionRepository.findById(id).isPresent()) {
            return Optional.ofNullable(variacionRepository.save(variacion));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        variacionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        variacionRepository.deleteAll();
    }

    @Transactional(readOnly = true)
    public Optional login(Variacion variacion) {
        return Optional.ofNullable(variacionRepository.findById(variacion.getId()));
    }

}
