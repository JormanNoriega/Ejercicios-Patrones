package solid.s;

public class EjemploIncorrecto {
    public static void main(String[] args) {
        PedidoIncorrecto pedido = new PedidoIncorrecto();
        pedido.agregarProducto("Cuaderno", 10000);
        pedido.calcularTotal();
        pedido.guardarEnBaseDatos();
    }
}

// Esta clase mezcla datos, calculos y persistencia.
class PedidoIncorrecto {
    private double total;

    void agregarProducto(String producto, double precio) {
        total += precio;
    }

    void calcularTotal() {
        System.out.println("Total: $" + total);
    }

    void guardarEnBaseDatos() {
        System.out.println("Pedido guardado");
    }
}
