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
import org.una.tramites.dto.RequisitoDTO;
import org.una.tramites.entities.Requisito;
import org.una.tramites.services.IRequisitoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/requisitos")
@Api(tags = {"Requisitos"})
public class RequisitoController {

    @Autowired
    private IRequisitoService requisitoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una lista de todos los Requisitos", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Requisito> requisitoFound = requisitoService.findById(id);
            if (requisitoFound.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{variacionId}")
    @ApiOperation(value = "Obtiene una lista de todos los Requisitos", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> findByVariacionId(@PathVariable(value = "variacionId") Long variacionId) {
        try {
            Optional<List<Requisito>> requisitoFound = requisitoService.findByVariacionId(variacionId);
            if (requisitoFound.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los Requisitos", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<Requisito>> requisitoFound = requisitoService.findByEstado(estado);
            if (requisitoFound.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Requisitos", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Requisito>> requisitoFound = requisitoService.findByFechaRegistroBetween(startDate, endDate);
            if (requisitoFound.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);
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
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> create(@RequestBody Requisito requisito) {
        try {
            Requisito requisitoCreated = requisitoService.create(requisito);
            RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoCreated, RequisitoDTO.class);
            return new ResponseEntity<>(requisitoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = RequisitoDTO.class, responseContainer = "List", tags = "Requisitos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Requisito requisitoModified) {
        try {
            Optional<Requisito> requisitoUpdated = requisitoService.update(requisitoModified, id);
            if (requisitoUpdated.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoUpdated.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);

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
