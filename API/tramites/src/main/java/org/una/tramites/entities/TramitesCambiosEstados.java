package org.una.tramites.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "TramitesCambiosEstados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TramitesCambiosEstados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha_Registro", updatable = false)
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "TramitesRegistrados_Id")
    private TramitesRegistrados tramitesRegistrados;
    
    @ManyToOne
    @JoinColumn(name = "TramitesEstados_Id")
    private TramitesEstados tramitesEstados;
 
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaRegistro = new Date();
    }
}
