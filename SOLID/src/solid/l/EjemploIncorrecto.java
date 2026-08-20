package solid.l;

public class EjemploIncorrecto {
    public static void main(String[] args) {
        // Esta llamada provoca una excepcion y rompe el contrato de Empleado.
        mostrarSalario(new EmpleadoMedioTiempoIncorrecto());
    }

    static void mostrarSalario(EmpleadoIncorrecto empleado) {
        System.out.println(empleado.calcularSalario());
    }
}

class EmpleadoIncorrecto {
    public double calcularSalario() {
        return 2000000;
    }
}

class EmpleadoMedioTiempoIncorrecto extends EmpleadoIncorrecto {
    @Override
    public double calcularSalario() {
        throw new UnsupportedOperationException("No puede calcular el salario");
    }
}
