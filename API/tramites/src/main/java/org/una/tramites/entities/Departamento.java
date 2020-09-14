package org.una.tramites.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
 * @author Sergio
 */
@Entity
@Table(name = "Departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "Nombre")
    private String nombre;

    @Column(name = "Fecha_Registro", updatable = false)
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "Fecha_Modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "Estado")
    private boolean estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Usuario> usuarios = new ArrayList<>();
    

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

}
