package solid.d;

public class Main {
    public static void main(String[] args) {
        /* Se puede cambiar el canal sin modificar PedidoService. */
        PedidoService servicio = new PedidoService(new EmailNotificador());
        servicio.confirmarPedido();

        PedidoService otroServicio = new PedidoService(new WhatsAppNotificador());
        otroServicio.confirmarPedido();
    }
}
