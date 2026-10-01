package service;

import domain.notificacion.NotificacionFactory;

public class NotificacionService {

    private final NotificacionFactory factory;

    public NotificacionService(NotificacionFactory factory) {
        this.factory = factory;
    }

    public String enviar() {
        return factory.crear().enviar();
    }
}
