package solid.l;

public class EmpleadoPorComision extends Empleado {
    private final double ventas;
    private final double porcentaje;

    public EmpleadoPorComision(double ventas, double porcentaje) {
        if (ventas < 0 || porcentaje < 0) {
            throw new IllegalArgumentException("Ventas y porcentaje deben ser positivos");
        }
        this.ventas = ventas;
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularSalario() {
        return ventas * porcentaje;
    }
}
