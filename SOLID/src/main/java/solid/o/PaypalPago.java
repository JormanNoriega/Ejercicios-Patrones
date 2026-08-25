package solid.o;

public class PaypalPago implements MetodoPago {
    @Override
    public void pagar(double valor) {
        System.out.println("Pago con PayPal: $" + valor);
    }
}
