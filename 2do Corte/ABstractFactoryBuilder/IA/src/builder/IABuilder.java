package builder;

import domain.paquete.PaqueteIA;

public interface IABuilder {

    IABuilder conConsultar();

    IABuilder conReporte();

    IABuilder conNotificacion();

    PaqueteIA build();
}
