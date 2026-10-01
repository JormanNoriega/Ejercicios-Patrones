package domain.notificacion;

public class NotificacionGemini implements Notificacion {

    @Override
    public String enviar() {
        return "Esta enviando la notificacion con Gemini...";
    }
}
