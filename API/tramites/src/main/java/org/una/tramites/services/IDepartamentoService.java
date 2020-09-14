package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Departamento;

/**
 *
 * @author Sergio
 */
public interface IDepartamentoService {

    public Optional<List<Departamento>> findAll();

    public Optional<Departamento> findById(Long id);

    public Optional<List<Departamento>> findByEstado(boolean estado);

    public Departamento create(Departamento departamento);

    public Optional<Departamento> update(Departamento departamento, boolean estado);

    public void delete(boolean estado);

    public void deleteAll();

    public Optional<Departamento> login(Departamento departamento);

}

