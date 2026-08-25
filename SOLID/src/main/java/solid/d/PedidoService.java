package solid.d;

import java.util.Objects;

public class PedidoService {
    private final Notificador notificador;

    public PedidoService(Notificador notificador) {
        this.notificador = Objects.requireNonNull(notificador, "El notificador es obligatorio");
    }

    public void confirmarPedido() {
        notificador.enviar("El pedido fue confirmado");
    }
}
