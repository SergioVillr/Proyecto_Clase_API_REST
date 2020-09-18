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
public class ArchivoRelacionadoDTO {
    
    private Long id;
    private Long tramitesRegistradosId;
    private String nombre;
    private boolean tipo;
    private boolean estado;
    private String rutaArchivo;
    private Date fechaRegistro;
    private String etiqueta;
    private Date fechaModificacion;
}
