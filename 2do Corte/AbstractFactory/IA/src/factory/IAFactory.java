package factory;

import domain.consultar.Consultar;
import domain.notificacion.Notificacion;
import domain.reporte.Reporte;

public interface IAFactory {

    Consultar crearConsultar();

    Reporte crearReporte();

    Notificacion crearNotificacion();
}
