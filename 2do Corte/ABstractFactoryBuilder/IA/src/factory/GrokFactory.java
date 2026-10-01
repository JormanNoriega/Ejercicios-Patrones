package factory;

import builder.IABuilder;
import domain.consultar.Consultar;
import domain.consultar.ConsultarGrok;
import domain.notificacion.Notificacion;
import domain.notificacion.NotificacionGrok;
import domain.paquete.PaqueteIA;
import domain.reporte.Reporte;
import domain.reporte.ReporteGrok;

public class GrokFactory implements IAFactory, IABuilder {

    private final PaqueteIA paquete = new PaqueteIA();

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
