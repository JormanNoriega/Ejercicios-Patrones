package domain.notificacion;

public class NotificacionGrok implements Notificacion {

    @Override
    public String enviar() {
        return "Esta enviando la notificacion con Grok...";
    }
}
