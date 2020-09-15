package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Requisito;
import org.una.tramites.repositories.IRequisitoRepository;

/**
 *
 * @author chris
 */
@Service
public class RequisitoServiceImplementation implements IRequisitoService {

    @Autowired
    private IRequisitoRepository requisitoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Requisito> findById(Long id) {
        return requisitoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Requisito>> findByVariacionId(Long variacionId) {
        return requisitoRepository.findByVariacionId(variacionId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Requisito>> findByEstado(boolean estado) {
        return requisitoRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Requisito>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return requisitoRepository.findByFechaRegistroBetween(startDate, endDate);
    }

    @Override
    @Transactional
    public Requisito create(Requisito requisito) {
        return requisitoRepository.save(requisito);
    }

    @Override
    @Transactional
    public Optional<Requisito> update(Requisito requisito, Long id) {
        if (requisitoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(requisitoRepository.save(requisito));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        requisitoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        requisitoRepository.deleteAll();
    }

    @Transactional(readOnly = true)
    public Optional login(Requisito requisito) {
        return Optional.ofNullable(requisitoRepository.findById(requisito.getId()));
    }

}
