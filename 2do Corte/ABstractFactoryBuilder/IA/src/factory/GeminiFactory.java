package factory;

import builder.IABuilder;
import domain.consultar.Consultar;
import domain.consultar.ConsultarGemini;
import domain.notificacion.Notificacion;
import domain.notificacion.NotificacionGemini;
import domain.paquete.PaqueteIA;
import domain.reporte.Reporte;
import domain.reporte.ReporteGemini;

public class GeminiFactory implements IAFactory, IABuilder {

    private final PaqueteIA paquete = new PaqueteIA();

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

    @Override
    public IABuilder conConsultar() {
        paquete.setConsultar(crearConsultar());
        return this;
    }

    @Override
    public IABuilder conReporte() {
        paquete.setReporte(crearReporte());
        return this;
    }

    @Override
    public IABuilder conNotificacion() {
        paquete.setNotificacion(crearNotificacion());
        return this;
    }

    @Override
    public PaqueteIA build() {
        return paquete;
    }
}
