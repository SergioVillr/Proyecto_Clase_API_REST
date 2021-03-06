package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.entities.Usuario;

/**
 *
 * @author Sergio
 */
public interface IUsuarioService {

    public Optional<List<Usuario>> findAll();

    public Optional<Usuario> findById(Long id);

    public Optional<List<Usuario>> findByCedulaAproximate(String cedula);

    public Optional<List<Usuario>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public Usuario create(Usuario usuario);

    public Optional<Usuario> update(Usuario usuario, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<Usuario> login(Usuario usuario); 
    
    public Optional<Usuario> findByCedula(String cedula);
    
    public UserDetails loadUserByUsername(String username);

    public String login(AuthenticationRequest authenticationRequest);
    
}

