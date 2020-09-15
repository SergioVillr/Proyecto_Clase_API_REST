package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.Usuario;
import org.una.tramites.repositories.IPermisoRepository;
import org.una.tramites.utils.MapperUtils;
/**
 *
 * @author Sergio
 */
@Service
public class PermisoServiceImplementation implements IPermisoService {

    @Autowired
    private IPermisoRepository permisoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Permiso> findById(Long id) {
        return permisoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Permiso>> findByEstado(boolean estado) {
        return permisoRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return permisoRepository.findByFechaRegistroBetween(startDate, endDate);
    }

    @Override
    @Transactional
    public Permiso create(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    @Override
    @Transactional
    public Optional<Permiso> update(Permiso permiso, Long id) {
        if (permisoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(permisoRepository.save(permiso));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        permisoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        permisoRepository.deleteAll();
    }

    @Transactional(readOnly = true)
    public Optional login(Permiso permiso) {
        return Optional.ofNullable(permisoRepository.findById(permiso.getId()));
    } 

    @Override
    public Optional<Permiso> findByCodigo(String Codigo) {
        return permisoRepository.findByCodigo(Codigo);
    }

    @Override
    public Long countByEstado(boolean estado) {
        return permisoRepository.countByEstado(estado);
    }
}
