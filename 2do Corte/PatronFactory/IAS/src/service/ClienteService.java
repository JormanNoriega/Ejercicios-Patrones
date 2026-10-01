package service;

import domain.Proveedor;
import domain.consultar.ConsultarFactory;
import domain.consultar.ConsultarGeminiFactory;
import domain.consultar.ConsultarGrokFactory;
import domain.notificacion.NotificacionFactory;
import domain.notificacion.NotificacionGeminiFactory;
import domain.notificacion.NotificacionGrokFactory;
import domain.reporte.ReporteFactory;
import domain.reporte.ReporteGeminiFactory;
import domain.reporte.ReporteGrokFactory;

public class ClienteService {

    private final Proveedor proveedor;
    private final ConsultarService consultar;
    private final ReporteService reporte;
    private final NotificacionService notificacion;

    public ClienteService(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.consultar = new ConsultarService(crearConsultarFactory(proveedor));
        this.reporte = new ReporteService(crearReporteFactory(proveedor));
        this.notificacion = new NotificacionService(crearNotificacionFactory(proveedor));
    }

    private static ConsultarFactory crearConsultarFactory(Proveedor proveedor) {
        switch (proveedor) {
            case GROK:
                return new ConsultarGrokFactory();
            case GEMINI:
                return new ConsultarGeminiFactory();
            default:
                throw new IllegalArgumentException("Proveedor desconocido: " + proveedor);
        }
    }

    private static ReporteFactory crearReporteFactory(Proveedor proveedor) {
        switch (proveedor) {
            case GROK:
                return new ReporteGrokFactory();
            case GEMINI:
                return new ReporteGeminiFactory();
            default:
                throw new IllegalArgumentException("Proveedor desconocido: " + proveedor);
        }
    }

    private static NotificacionFactory crearNotificacionFactory(Proveedor proveedor) {
        switch (proveedor) {
            case GROK:
                return new NotificacionGrokFactory();
            case GEMINI:
                return new NotificacionGeminiFactory();
            default:
                throw new IllegalArgumentException("Proveedor desconocido: " + proveedor);
        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public String consultar() {
        return consultar.consultar();
    }

    public String reporte() {
        return reporte.generarReporte();
    }

    public String notificacion() {
        return notificacion.enviar();
    }
}
