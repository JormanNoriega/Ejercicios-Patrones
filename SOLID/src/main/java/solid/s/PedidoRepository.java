package solid.s;

public class PedidoRepository {
    public void guardar(Pedido pedido) {
        System.out.println("Pedido guardado con " + pedido.getProductos().size() + " productos");
    }
}
