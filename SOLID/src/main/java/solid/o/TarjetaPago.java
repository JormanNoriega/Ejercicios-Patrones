package solid.o;

public class TarjetaPago implements MetodoPago {
    @Override
    public void pagar(double valor) {
        System.out.println("Pago con tarjeta: $" + valor);
    }
}
