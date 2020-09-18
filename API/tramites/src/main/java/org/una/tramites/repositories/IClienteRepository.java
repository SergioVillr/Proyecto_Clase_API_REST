package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.Cliente;

/**
 *
 * @author Sergio
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    public Cliente findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado);

    public List<Cliente> findByCedulaContaining(String cedula);

    public List<Cliente> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);
    
    @Query("select c from Cliente c where UPPER(c.nombreCompleto) like CONCAT('%', UPPER(:nombreCompleto), '%')")
    public Cliente findNombreCompletoWithLikeSQL(@Param("nombreCompleto")String nombreCompleto);

    @Query("select c from Cliente c where c.cedula = :cedula")
    public Cliente findByCedula(@Param("cedula")String cedula);
}
