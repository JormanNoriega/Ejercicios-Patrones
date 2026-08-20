package solid.s;

public class Main {
    public static void main(String[] args) {
        /*
         * Incorrecto: Pedido tambien calcularia el total y guardaria datos.
         * Correcto: cada clase tiene una unica responsabilidad.
         */
        Pedido pedido = new Pedido();
        pedido.agregarProducto("Cuaderno", 10000);

        CalculadoraPedido calculadora = new CalculadoraPedido();
        System.out.println("Total calculado: $" + calculadora.calcularTotal(pedido));

        new PedidoRepository().guardar(pedido);
    }
}
