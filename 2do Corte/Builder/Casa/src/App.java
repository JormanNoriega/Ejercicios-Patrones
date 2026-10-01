import java.util.Scanner;

import builder.CasaBuilder;
import builder.Director;
import builder.ICasaBuilder;
import domain.Casa;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la casa a construir:");
        System.out.println("1) Casa basica");
        System.out.println("2) Casa grande");
        System.out.println("3) Casa moderna");
        System.out.print("Opcion: ");

        String opcion = scanner.nextLine().trim();

        while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")) {
            System.out.print("Opcion invalida, ingrese 1, 2 o 3: ");
            opcion = scanner.nextLine().trim();
        }

        ICasaBuilder builder = new CasaBuilder();
        Director director = new Director(builder);

        Casa casa;
        if (opcion.equals("1")) {
            casa = director.casaBasica();
            System.out.println();
            System.out.println("--- Casa basica ---");
        } else if (opcion.equals("2")) {
            casa = director.casaGrande();
            System.out.println();
            System.out.println("--- Casa grande ---");
        } else {
            casa = director.casaModerna();
            System.out.println();
            System.out.println("--- Casa moderna ---");
        }

        System.out.println(casa.mostrarCasa());

        scanner.close();
    }
}
