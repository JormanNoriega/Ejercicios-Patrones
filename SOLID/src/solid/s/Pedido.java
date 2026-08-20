package solid.s;

public class Pedido {
    private double total;

    public void agregarProducto(String producto, double precio) {
        total += precio;
        System.out.println("Producto agregado: " + producto);
    }

    public double getTotal() {
        return total;
    }
}
