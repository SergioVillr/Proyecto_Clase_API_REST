package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.ParametrosGenerales;

/**
 *
 * @author Sergio
 */
public interface IParametrosGeneralesRepository extends JpaRepository<ParametrosGenerales, Long>{
    public List<ParametrosGenerales> findByNombre(String nombre);
    
    public List<ParametrosGenerales> findByValor(String valor);
    
    public List<ParametrosGenerales> findByDescripcion(String descripcion);
}
