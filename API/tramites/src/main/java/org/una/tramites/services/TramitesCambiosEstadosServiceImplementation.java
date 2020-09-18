/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.una.tramites.entities.TramitesCambiosEstados;
import org.una.tramites.repositories.ITramitesCambiosEstadosRepository;

/**
 *
 * @author Kender Porras
 */
public class TramitesCambiosEstadosServiceImplementation implements ITramitesCambiosEstadosService {

    @Autowired
    private ITramitesCambiosEstadosRepository tramitesCambiosEstadosRepository;

    @Override
    public Optional<List<TramitesCambiosEstados>> findAll() {
        return Optional.ofNullable(tramitesCambiosEstadosRepository.findAll());
    }

    @Override
    public Optional<TramitesCambiosEstados> findById(Long id) {
        return tramitesCambiosEstadosRepository.findById(id);
    }

    @Override
    public TramitesCambiosEstados create(TramitesCambiosEstados tramitesCambiosEstados) {
        return tramitesCambiosEstadosRepository.save(tramitesCambiosEstados);
    }

    @Override
    public Optional<TramitesCambiosEstados> update(TramitesCambiosEstados tramitesCambiosEstados, Long id) {
        if (tramitesCambiosEstadosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramitesCambiosEstadosRepository.save(tramitesCambiosEstados));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        tramitesCambiosEstadosRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tramitesCambiosEstadosRepository.deleteAll();
    }

}
