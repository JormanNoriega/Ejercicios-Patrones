package service;

import domain.reporte.ReporteFactory;

public class ReporteService {

    private final ReporteFactory factory;

    public ReporteService(ReporteFactory factory) {
        this.factory = factory;
    }

    public String generarReporte() {
        return factory.crear().generarReporte();
    }
}
