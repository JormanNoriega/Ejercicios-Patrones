package builder;

import domain.paquete.PaqueteIA;

public class Director {

    private final IABuilder builder;

    public Director(IABuilder builder) {
        this.builder = builder;
    }

    public PaqueteIA construirPaqueteCompleto() {
        return builder
                .conConsultar()
                .conReporte()
                .conNotificacion()
                .build();
    }

    public PaqueteIA construirSoloConsulta() {
        return builder
                .conConsultar()
                .build();
    }

    public PaqueteIA construirConsultaYReporte() {
        return builder
                .conConsultar()
                .conReporte()
                .build();
    }
}
