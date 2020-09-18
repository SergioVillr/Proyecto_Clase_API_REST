package org.una.tramites.dto;


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
public class TramitesRegistradosDTO {
    private Long id;
    private Long clienteId;
    private int tramiteTipoId;
   
}
