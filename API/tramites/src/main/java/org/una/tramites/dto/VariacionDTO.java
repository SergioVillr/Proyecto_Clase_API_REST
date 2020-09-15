package org.una.tramites.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author chris
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VariacionDTO {

    private Long id;
    private Long tramiteTipoId;
    private boolean grupo;
    private String descripcion;
    private boolean estado;
    private Date fechaRegistro;
}
