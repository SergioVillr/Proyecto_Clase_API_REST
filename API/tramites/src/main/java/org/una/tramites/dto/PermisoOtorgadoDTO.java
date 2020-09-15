package org.una.tramites.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *
 * @author Sergio
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermisoOtorgadoDTO {

    private Long Id;
    private Long UsuarioId;
    private Long PermisoId;
    private Date fechaRegistro;
    private boolean estado;
}
