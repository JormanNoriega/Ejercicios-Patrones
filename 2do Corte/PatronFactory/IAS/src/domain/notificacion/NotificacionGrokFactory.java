package domain.notificacion;

public class NotificacionGrokFactory extends NotificacionFactory {

    @Override
    public Notificacion crear() {
        return new NotificacionGrok();
    }
}
