package solid.d;

public class EjemploIncorrecto {
    public static void main(String[] args) {
        new PedidoServiceIncorrecto().confirmarPedido();
    }
}

// El servicio depende directamente de una clase concreta.
class PedidoServiceIncorrecto {
    void confirmarPedido() {
        new EmailNotificador().enviar("El pedido fue confirmado");
    }
}
