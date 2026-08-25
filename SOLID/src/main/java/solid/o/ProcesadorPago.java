package solid.o;

public class ProcesadorPago {
    private final MetodoPago metodoPago;

    public ProcesadorPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesar(double valor) {
        metodoPago.pagar(valor);
    }
}
