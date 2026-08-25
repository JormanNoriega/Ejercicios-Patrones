package solid.s;

import java.math.BigDecimal;

public class CalculadoraPedido {
    public BigDecimal calcularTotal(Pedido pedido) {
        return pedido.getProductos().stream()
                .map(Producto::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
