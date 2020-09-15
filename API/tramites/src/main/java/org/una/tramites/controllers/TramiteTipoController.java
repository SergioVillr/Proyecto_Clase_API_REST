package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
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
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.services.ITramiteTipoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/tramitesTipos")
@Api(tags = {"TramitesTipos"})
public class TramiteTipoController {

    @Autowired
    private ITramiteTipoService tramiteTipoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una lista de todos los Tramites_Tipos", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramitesTipos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<TramiteTipo> tramiteTipoFound = tramiteTipoService.findById(id);
            if (tramiteTipoFound.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{departamentoId}")
    @ApiOperation(value = "Obtiene una lista de todos los Tramites_Tipos", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramitesTipos")
    public ResponseEntity<?> findByDepartamentoId(@PathVariable(value = "departamentoId") Long departamentoId) {
        try {
            Optional<List<TramiteTipo>> tramiteTipoFound = tramiteTipoService.findByDepartamentoId(departamentoId);
            if (tramiteTipoFound.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los Tramites_Tipos", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramitesTipos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<TramiteTipo>> tramiteTipoFound = tramiteTipoService.findByEstado(estado);
            if (tramiteTipoFound.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Tramites_Tipos", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramitesTipos")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<TramiteTipo>> tramiteTipoFound = tramiteTipoService.findByFechaRegistroBetween(startDate, endDate);
            if (tramiteTipoFound.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);
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
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramiteTipo")
    public ResponseEntity<?> create(@RequestBody TramiteTipo tramiteTipo) {
        try {
            TramiteTipo tramiteTipoCreated = tramiteTipoService.create(tramiteTipo);
            TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoCreated, TramiteTipoDTO.class);
            return new ResponseEntity<>(tramiteTipoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = TramiteTipoDTO.class, responseContainer = "List", tags = "TramiteTipo")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TramiteTipo tramiteTipoModified) {
        try {
            Optional<TramiteTipo> tramiteTipoUpdated = tramiteTipoService.update(tramiteTipoModified, id);
            if (tramiteTipoUpdated.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoUpdated.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return null;
        //TODO: Implementar este método

    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
        return null;
        //TODO: Implementar este método
    }

}
