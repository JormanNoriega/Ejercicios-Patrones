package solid.d;

public class Main {
    public static void main(String[] args) {
        /* PedidoService depende de Notificador, no de EmailNotificador. */
        PedidoService servicio = new PedidoService(new EmailNotificador());
        servicio.confirmarPedido();

        PedidoService otroServicio = new PedidoService(new WhatsAppNotificador());
        otroServicio.confirmarPedido();
    }
}
