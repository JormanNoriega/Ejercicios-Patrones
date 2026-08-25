package solid.o;

public class EjemploIncorrecto {
    public static void main(String[] args) {
        pagar("tarjeta", 25000);
    }

    // Cada nuevo metodo de pago obliga a modificar esta funcion.
    static void pagar(String tipo, double valor) {
        if (tipo.equals("tarjeta")) {
            System.out.println("Pago con tarjeta: $" + valor);
        } else if (tipo.equals("paypal")) {
            System.out.println("Pago con PayPal: $" + valor);
        }
    }
}
