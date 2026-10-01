import java.util.Scanner;

import builder.Director;
import builder.IABuilder;
import domain.Proveedor;
import domain.paquete.PaqueteIA;
import factory.FactoryProducer;
import factory.IAFactory;

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

        System.out.println();
        System.out.println("IA seleccionada: " + proveedor);

        System.out.println();
        System.out.println("--- Abstract Factory: productos individuales ---");
        IAFactory fabrica = FactoryProducer.crear(proveedor);
        System.out.println(fabrica.crearConsultar().consultar());
        System.out.println(fabrica.crearReporte().generarReporte());
        System.out.println(fabrica.crearNotificacion().enviar());

        System.out.println();
        System.out.println("--- Builder + Director: paquete completo ---");
        Director directorCompleto = new Director(FactoryProducer.crearBuilder(proveedor));
        PaqueteIA paqueteCompleto = directorCompleto.construirPaqueteCompleto();
        System.out.println(paqueteCompleto.ejecutarTodo());

        System.out.println();
        System.out.println("--- Builder + Director: receta solo consulta ---");
        Director directorConsulta = new Director(FactoryProducer.crearBuilder(proveedor));
        PaqueteIA paqueteConsulta = directorConsulta.construirSoloConsulta();
        System.out.println(paqueteConsulta.ejecutarTodo());

        scanner.close();
    }
}
