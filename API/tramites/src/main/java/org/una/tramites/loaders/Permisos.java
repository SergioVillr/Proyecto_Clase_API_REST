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
    ColsultarReportesTransacciones("TRU1"),
    Consultarreportedealertasdefavoritismo("TRU2"),
    Registrartramitepropio("TAG1"),	
    Consultartramitepropio("TAG2"),
    Consultarreportedetramitesporusuarios("REP1"),	
    Consultarreportedetramitesporfechas("REP2"),
    Consultarreportedetramitesportipos("REP3"),	
    Consultarreportedetramitesporestados("REP4"),	
    Consultarreportedetramitespordepartamentos("REP5"),	
    Consultarreportedetrámitesporcliente("REP6");	

    
    private String codigo;
    
    Permisos(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
}
