public class Alquiler {

    private Vehiculo vehiculo;
    private int dias;

    public Alquiler(Vehiculo vehiculo, int dias) {
        this.vehiculo = vehiculo;
        this.dias = dias;
    }

    public void mostrarAlquiler() {

        vehiculo.mostrarInformacion();

        System.out.println("Días de alquiler: " + dias);
        System.out.println("Costo total: $" + vehiculo.calcularCosto(dias));
        System.out.println("-----------------------------");
    }
}