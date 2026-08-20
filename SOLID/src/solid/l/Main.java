package solid.l;

public class Main {
    public static void main(String[] args) {
        mostrarSalario(new EmpleadoTiempoCompleto());
        mostrarSalario(new EmpleadoMedioTiempo());
    }

    private static void mostrarSalario(Empleado empleado) {
        System.out.println("Salario: $" + empleado.calcularSalario());
    }
}
