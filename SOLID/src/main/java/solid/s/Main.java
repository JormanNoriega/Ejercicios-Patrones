package solid.s;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        /*
         * Incorrecto: Pedido tambien calcularia el total y guardaria datos.
         * Correcto: cada clase tiene una unica responsabilidad.
         */
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Cuaderno", new BigDecimal("10000")));
        pedido.agregarProducto(new Producto("Lapicero", new BigDecimal("2500")));

        CalculadoraPedido calculadora = new CalculadoraPedido();
        System.out.println("Total calculado: $" + calculadora.calcularTotal(pedido));

        new PedidoRepository().guardar(pedido);
    }
}
