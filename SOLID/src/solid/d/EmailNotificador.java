package solid.d;

public class EmailNotificador implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}
