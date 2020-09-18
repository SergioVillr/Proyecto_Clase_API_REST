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
@Table(name = "Requisitos_Presentado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequisitoPresentado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "tramites_registrados_id")
    private TramitesRegistrados tramitesRegistrados;

    @ManyToOne
    @JoinColumn(name = "requisito_id")
    private Requisito requisito;
 
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

        fechaRegistro = new Date();

    }
}
