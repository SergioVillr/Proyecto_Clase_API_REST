package org.una.tramites.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Chris
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class ParametrosGeneralesDTO {

    private Long id;
    private String nombre;
    private String valor;
    private String descripcion;
    private Date fechaRegistro;
    private Date fechaModificacion;
}
