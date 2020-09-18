package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.TramitesCambiosEstadosDTO;
import org.una.tramites.entities.TramitesCambiosEstados;
import org.una.tramites.services.ITramitesCambiosEstadosService;
import org.una.tramites.utils.MapperUtils;

/*
 *
 * @author Sergio
 *
 */
@RestController
@RequestMapping("/tramites_cambios_estados")
@Api(tags = {"Tramites_Cambios_Estados"})
public class TramitesCambiosEstadosController {
    /*  
    @Autowired
    private ITramitesCambiosEstadosService tramitesCambiosEstadosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los tramites cambios de estados", response = TramitesCambiosEstadosDTO.class, responseContainer = "List", tags = "Tramites_Cambios_Estados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TramitesCambiosEstados>> result = tramitesCambiosEstadosService.findAll();
            if (result.isPresent()) {
                List<TramitesCambiosEstadosDTO> tramiteCambiosEstadosDTO = MapperUtils.DtoListFromEntityList(result.get(), TramitesCambiosEstadosDTO.class);
                return new ResponseEntity<>(tramiteCambiosEstadosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un tramite cambios de estados a travez de su identificador unico", response = TramitesCambiosEstadosDTO.class, tags = "Tramites_Cambios_Estados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TramitesCambiosEstados> tramitesFound = tramitesCambiosEstadosService.findById(id);
            if (tramitesFound.isPresent()) {
                TramitesCambiosEstadosDTO tramiteCambiosEstadosDTO = MapperUtils.DtoFromEntity(tramitesFound.get(), TramitesCambiosEstadosDTO.class);
                return new ResponseEntity<>(tramiteCambiosEstadosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TramitesCambiosEstados tramites) {
        try {
            TramitesCambiosEstados tramitesCreated = tramitesCambiosEstadosService.create(tramites);
            TramitesCambiosEstadosDTO tramiteCambiosEstadosDTO = MapperUtils.DtoFromEntity(tramitesCreated, TramitesCambiosEstadosDTO.class);
            return new ResponseEntity<>(tramiteCambiosEstadosDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TramitesCambiosEstados traModified) {
        try {
            Optional<TramitesCambiosEstados> tramitesUpdated = tramitesCambiosEstadosService.update(traModified, id);
            if (tramitesUpdated.isPresent()) {
                TramitesCambiosEstadosDTO tramiteCambiosEstadosDTO = MapperUtils.DtoFromEntity(tramitesUpdated.get(), TramitesCambiosEstadosDTO.class);
                return new ResponseEntity<>(tramiteCambiosEstadosDTO, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            tramitesCambiosEstadosService.delete(id);
            if (findById(id).getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
        try {
            tramitesCambiosEstadosService.deleteAll();
            if (findAll().getStatusCode() == HttpStatus.NO_CONTENT) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}
