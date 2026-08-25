package solid.d;

public class WhatsAppNotificador implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("WhatsApp enviado: " + mensaje);
    }
}
