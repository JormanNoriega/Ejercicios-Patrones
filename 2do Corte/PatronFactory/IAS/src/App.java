import java.util.Scanner;

import domain.Proveedor;
import service.ClienteService;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la IA a utilizar:");
        System.out.println("1) Grok");
        System.out.println("2) Gemini");
        System.out.print("Opcion: ");

        String opcion = scanner.nextLine().trim();

        while (!opcion.equals("1") && !opcion.equals("2")) {
            System.out.print("Opcion invalida, ingrese 1 o 2: ");
            opcion = scanner.nextLine().trim();
        }

        Proveedor proveedor = opcion.equals("1") ? Proveedor.GROK : Proveedor.GEMINI;

        ClienteService cliente = new ClienteService(proveedor);

        System.out.println();
        System.out.println("IA seleccionada: " + cliente.getProveedor());
        System.out.println(cliente.consultar());
        System.out.println(cliente.reporte());
        System.out.println(cliente.notificacion());

        scanner.close();
    }
}
