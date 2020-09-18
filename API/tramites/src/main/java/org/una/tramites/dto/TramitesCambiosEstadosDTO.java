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
public class TramitesCambiosEstadosDTO {
    private Long id;
    private Long usuarioId;
    private Long tramitesRegistradosId;
    private Long tramitesEstadosId;
    private Date fechaRegistro;
}
