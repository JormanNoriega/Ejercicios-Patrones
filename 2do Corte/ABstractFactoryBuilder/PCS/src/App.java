import java.util.Scanner;

import builder.ComputadorBuilder;
import builder.Director;
import domain.TipoPC;
import domain.computador.Computador;
import factory.ComputadorFactory;
import factory.FactoryProducer;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de computador:");
        System.out.println("1) Gaming");
        System.out.println("2) Oficina");
        System.out.print("Opcion: ");

        String opcion = scanner.nextLine().trim();

        while (!opcion.equals("1") && !opcion.equals("2")) {
            System.out.print("Opcion invalida, ingrese 1 o 2: ");
            opcion = scanner.nextLine().trim();
        }

        TipoPC tipo = opcion.equals("1") ? TipoPC.GAMING : TipoPC.OFICINA;

        System.out.println();
        System.out.println("Tipo seleccionado: " + tipo);

        System.out.println();
        System.out.println("--- Abstract Factory: componentes individuales ---");
        ComputadorFactory fabrica = FactoryProducer.crear(tipo);
        System.out.println(fabrica.crearProcesador().descripcion());
        System.out.println(fabrica.crearMemoria().descripcion());
        System.out.println(fabrica.crearAlmacenamiento().descripcion());
        System.out.println(fabrica.crearGrafica().descripcion());

        System.out.println();
        System.out.println("--- Builder + Director: receta completa ---");
        Director directorCompleto = new Director(FactoryProducer.crearBuilder(tipo));
        Computador completo = directorCompleto.construirCompleto();
        System.out.println(completo.mostrarConfiguracion());

        System.out.println();
        System.out.println("--- Builder + Director: receta sin grafica ---");
        Director directorSinGrafica = new Director(FactoryProducer.crearBuilder(tipo));
        Computador sinGrafica = directorSinGrafica.construirSinGrafica();
        System.out.println(sinGrafica.mostrarConfiguracion());

        scanner.close();
    }
}
