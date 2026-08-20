package solid.o;

public class Main {
    public static void main(String[] args) {
        /* Agregar Nequi no obliga a modificar TarjetaPago ni PaypalPago. */
        MetodoPago pago = new NequiPago();
        pago.pagar(25000);
    }
}
