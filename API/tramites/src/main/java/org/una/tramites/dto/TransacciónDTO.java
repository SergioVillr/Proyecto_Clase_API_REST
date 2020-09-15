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
public class TransacciónDTO {

    private Long Id;
    private Date fechaRegistro;
    private Long PermisoOtorgadoId;
    private String objeto;
    private String informacion;

    private Long UsuarioId;
    private Long PermisoId;
}
