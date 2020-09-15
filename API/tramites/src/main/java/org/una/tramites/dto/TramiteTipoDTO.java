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
public class TramiteTipoDTO {

    private Long Id;
    private String descripcion;
    private boolean estado;
    private Long departamentoId;
    private Date fechaRegistro;
    private Date fechaModificacion;
}
