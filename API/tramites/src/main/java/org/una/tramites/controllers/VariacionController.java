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
import org.una.tramites.dto.VariacionDTO;
import org.una.tramites.entities.Variacion;
import org.una.tramites.services.IVariacionService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/variaciones")
@Api(tags = {"Variaciones"})
public class VariacionController {

    @Autowired
    private IVariacionService variacionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una lista de todos los Variaciones", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Variacion> variacionFound = variacionService.findById(id);
            if (variacionFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{tramiteTipoId}")
    @ApiOperation(value = "Obtiene una lista de todos los Variaciones", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> findByTramiteTipoId(@PathVariable(value = "tramiteTipoId") Long tramiteTipoId) {
        try {
            Optional<List<Variacion>> variacionFound = variacionService.findByTramiteTipoId(tramiteTipoId);
            if (variacionFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{tramiteTipoId}/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los Variaciones", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> findByTramiteTipoIdAndEstado(@PathVariable(value = "tramiteTipoId") Long tramiteTipoId, @PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<Variacion>> variacionFound = variacionService.findByTramiteTipoIdAndEstado(tramiteTipoId, estado);
            if (variacionFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Variaciones", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<Variacion>> variacionFound = variacionService.findByFechaRegistroBetween(startDate, endDate);
            if (variacionFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
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
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> create(@RequestBody Variacion variacion) {
        try {
            Variacion variacionCreated = variacionService.create(variacion);
            VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionCreated, VariacionDTO.class);
            return new ResponseEntity<>(variacionDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = VariacionDTO.class, responseContainer = "List", tags = "Variaciones")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Variacion variacionModified) {
        try {
            Optional<Variacion> variacionUpdated = variacionService.update(variacionModified, id);
            if (variacionUpdated.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionUpdated.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);

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
