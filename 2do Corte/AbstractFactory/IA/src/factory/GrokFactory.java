package factory;

import domain.consultar.Consultar;
import domain.consultar.ConsultarGrok;
import domain.notificacion.Notificacion;
import domain.notificacion.NotificacionGrok;
import domain.reporte.Reporte;
import domain.reporte.ReporteGrok;

public class GrokFactory implements IAFactory {

    @Override
    public Consultar crearConsultar() {
        return new ConsultarGrok();
    }

    @Override
    public Reporte crearReporte() {
        return new ReporteGrok();
    }

    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionGrok();
    }
}
