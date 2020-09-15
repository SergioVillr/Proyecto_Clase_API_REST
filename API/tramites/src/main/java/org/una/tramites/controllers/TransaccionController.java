package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.TransacciónDTO;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.services.ITransaccionService;
import org.una.tramites.utils.MapperUtils;
/**
 *
 * @author expz
 */
@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})
public class TransaccionController {

    @Autowired
    private ITransaccionService transaccionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una lista de todos las Transacciones", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Transaccion> transaccionFound = transaccionService.findById(id);
            if (transaccionFound.isPresent()) {
                TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransacciónDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{usuarioId}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Transacciones", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findByUsuarioIdAndFechaRegistroBetween(@PathVariable(value = "usuarioId") Long usuarioId, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> transaccionFound = transaccionService.findByUsuarioIdAndFechaRegistroBetween(usuarioId, startDate, endDate);
            if (transaccionFound.isPresent()) {
                TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransacciónDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{permisoId}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Transacciones", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findByPermisoIdAndFechaRegistroBetween(@PathVariable(value = "permisoId") Long permisoId, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> transaccionFound = transaccionService.findByPermisoIdAndFechaRegistroBetween(permisoId, startDate, endDate);
            if (transaccionFound.isPresent()) {
                TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransacciónDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{objeto}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Transacciones", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findByObjetoAndFechaRegistroBetween(@PathVariable(value = "objeto") String objeto, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> transaccionFound = transaccionService.findByObjetoAndFechaRegistroBetween(objeto, startDate, endDate);
            if (transaccionFound.isPresent()) {
                TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransacciónDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Transacciones", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Transaccion>> transaccionFound = transaccionService.findByFechaRegistroBetween(startDate, endDate);
            if (transaccionFound.isPresent()) {
                TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransacciónDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
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
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = TransacciónDTO.class, responseContainer = "List", tags = "Transacciones")
    public ResponseEntity<?> create(@RequestBody Transaccion transaccion) {
        try {
            Transaccion transaccionCreated = transaccionService.create(transaccion);
            TransacciónDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionCreated, TransacciónDTO.class);
            return new ResponseEntity<>(transaccionDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
