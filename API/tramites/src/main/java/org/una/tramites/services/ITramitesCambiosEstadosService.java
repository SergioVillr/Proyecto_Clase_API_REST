/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.TramitesCambiosEstados;

/**
 *
 * @author Kender Porras
 */

public interface ITramitesCambiosEstadosService {

    public Optional<List<TramitesCambiosEstados>> findAll();

    public Optional<TramitesCambiosEstados> findById(Long id);

    public TramitesCambiosEstados create(TramitesCambiosEstados tramitesCambiosEstados);

    public Optional<TramitesCambiosEstados> update(TramitesCambiosEstados tramitesCambiosEstados, Long id);

    public void delete(Long id);

    public void deleteAll();
}
