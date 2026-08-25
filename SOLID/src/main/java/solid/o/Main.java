package solid.o;

public class Main {
    public static void main(String[] args) {
        /* El procesador no conoce la clase concreta del medio de pago. */
        ProcesadorPago procesador = new ProcesadorPago(new NequiPago());
        procesador.procesar(25000);
    }
}
