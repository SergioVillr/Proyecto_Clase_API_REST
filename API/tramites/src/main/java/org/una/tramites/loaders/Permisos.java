package org.una.tramites.loaders;

/**
 *
 * @author Sergio
 */
public enum Permisos {
    CrearUsuario("USU1"),
    ModificarUsuario("USU2"),
    InactivarUsuario("USU3"),
    ConsultarUsuario("USU4"),
    CrearDepartamento("DEP1"),
    ModificarDepartamento("DEP2"),
    InactivarDepartamento("DEP3"),
    ColsutarDepartamento("DEP4"),
    RegistratTramite("TRA1"),
    ModificarTramite("TRA2"),
    InactivarTramite("TRA3"),
    FinalizarTramite("TRA4"),
    ColsultarTramite("TRA5"),
    ColsultarTodosTramites("TRA6"),
    DiseñarTramitesVariacionesRequisitos("TRD1"),
    ColsultarReportesTransacciones("TRU1");
    //TODO: Completar esta lista
    private String codigo;
    
    Permisos(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
}
