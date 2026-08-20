package solid.d;

public class PedidoService {
    private final Notificador notificador;

    public PedidoService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void confirmarPedido() {
        notificador.enviar("El pedido fue confirmado");
    }
}
