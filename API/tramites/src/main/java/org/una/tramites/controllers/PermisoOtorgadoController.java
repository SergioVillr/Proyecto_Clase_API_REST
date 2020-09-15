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
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.services.IPermisoOtorgadoService;
import org.una.tramites.utils.MapperUtils;
/**
 *
 * @author Sergio
 */
@RestController
@RequestMapping("/permisosOtorgados")
@Api(tags = {"PermisosOtorgados"})
public class PermisoOtorgadoController {

    @Autowired
    private IPermisoOtorgadoService permisoOtorgadoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<PermisoOtorgado> permisoOtorgadoFound = permisoOtorgadoService.findById(id);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{UsuarioId}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByUsuarioId(@PathVariable(value = "usuarioId") Long usuarioId) {
        try {
            Optional<List<PermisoOtorgado>> permisoOtorgadoFound = permisoOtorgadoService.findByUsuarioId(usuarioId);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{PermisoId}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByPermisoId(@PathVariable(value = "permisoId") Long permisoId) {
        try {
            Optional<List<PermisoOtorgado>> permisoOtorgadoFound = permisoOtorgadoService.findByPermisoId(permisoId);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{usuarioId}/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByUsuarioIdAndEstado(@PathVariable(value = "usuarioId") Long usuarioId, @PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<PermisoOtorgado>> permisoOtorgadoFound = permisoOtorgadoService.findByUsuarioIdAndEstado(usuarioId, estado);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{permisoId}/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByPermisoIdAndEstado(@PathVariable(value = "permisoId") Long permisoId, @PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<PermisoOtorgado>> permisoOtorgadoFound = permisoOtorgadoService.findByPermisoIdAndEstado(permisoId, estado);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de todos los Permisos_Otorgados", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        try {
            Optional<List<PermisoOtorgado>> permisoOtorgadoFound = permisoOtorgadoService.findByFechaRegistroBetween(startDate, endDate);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
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
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> create(@RequestBody PermisoOtorgado permisoOtorgado) {
        try {
            PermisoOtorgado permisoOtorgadoCreated = permisoOtorgadoService.create(permisoOtorgado);
            PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoCreated, PermisoOtorgadoDTO.class);
            return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = PermisoOtorgadoDTO.class, responseContainer = "List", tags = "PermisosOtorgados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PermisoOtorgado permisoOtorgadoModified) {
        try {
            Optional<PermisoOtorgado> permisoOtorgadoUpdated = permisoOtorgadoService.update(permisoOtorgadoModified, id);
            if (permisoOtorgadoUpdated.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoUpdated.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);

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
