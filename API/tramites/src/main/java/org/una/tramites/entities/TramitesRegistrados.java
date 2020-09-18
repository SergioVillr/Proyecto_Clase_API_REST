package org.una.tramites.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "Tramites_Registrados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TramitesRegistrados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Tramite_Tipo_Id", length = 20)
    private int tramiteTipoId;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramitesRegistrados")
    private List<ArchivoRelacionado> archivoRelacionado = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramitesRegistrados")
    private List<Notas> notas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramitesRegistrados")
    private List<RequisitoPresentado> requisitoPresentado = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramitesRegistrados")
    private List<TramitesCambiosEstados> tramitesCambiosEstados = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
