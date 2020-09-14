package org.una.tramites.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;
import org.una.tramites.repositories.IDepartamentoRepository;

/**
 *
 * @author Sergio
 */
@Service
public class DepartamentoServiceImplementation implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    public Optional<List<Departamento>> findAll() {
        return Optional.ofNullable(departamentoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Optional<List<Departamento>> findByEstado(boolean estado) {
        return departamentoRepository.findByEstado(estado);
    }

    @Override
    @Transactional
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    @Transactional
    public Optional<Departamento> update(Departamento departamento, boolean estado) {
        if (departamentoRepository.findByEstado(estado).isPresent()) {
            return Optional.ofNullable(departamentoRepository.save(departamento));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(boolean estado) {
        departamentoRepository.deleteById(Long.MIN_VALUE);
    }

    @Override
    @Transactional
    public void deleteAll() {
        departamentoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional login(Departamento departamento) {
        return Optional.ofNullable(departamentoRepository.findByEstado(departamento.isEstado()));
    }

}
