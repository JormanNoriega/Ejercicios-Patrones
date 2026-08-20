public class Camion extends Vehiculo {

    private double cargoCarga;

    public Camion(String marca, String modelo, String placa,
                   double tarifaDiaria, double cargoCarga) {

        super(marca, modelo, placa, tarifaDiaria);
        this.cargoCarga = cargoCarga;
    }

    @Override
    public double calcularCosto(int dias) {
        return (getTarifaDiaria() * dias) + cargoCarga;
    }
}