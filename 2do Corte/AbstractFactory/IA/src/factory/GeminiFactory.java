package factory;

import domain.consultar.Consultar;
import domain.consultar.ConsultarGemini;
import domain.notificacion.Notificacion;
import domain.notificacion.NotificacionGemini;
import domain.reporte.Reporte;
import domain.reporte.ReporteGemini;

public class GeminiFactory implements IAFactory {

    @Override
    public Consultar crearConsultar() {
        return new ConsultarGemini();
    }

    @Override
    public Reporte crearReporte() {
        return new ReporteGemini();
    }

    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionGemini();
    }
}
