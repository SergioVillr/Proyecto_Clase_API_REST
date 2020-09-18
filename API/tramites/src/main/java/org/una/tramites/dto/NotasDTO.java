package org.una.tramites.dto;

import java.util.Date;
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
public class NotasDTO {
    private Long id;
    private boolean estado;
    private boolean tipo;
    private String titulo;
    private String contenido;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Long tramitesRegistradosId;
    
}
