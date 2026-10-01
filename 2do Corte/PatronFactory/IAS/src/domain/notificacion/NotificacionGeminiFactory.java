package domain.notificacion;

public class NotificacionGeminiFactory extends NotificacionFactory {

    @Override
    public Notificacion crear() {
        return new NotificacionGemini();
    }
}
