package solid.o;

public class NequiPago implements MetodoPago {
    @Override
    public void pagar(double valor) {
        System.out.println("Pago con Nequi: $" + valor);
    }
}
