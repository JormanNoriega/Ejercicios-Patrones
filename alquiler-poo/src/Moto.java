public class Moto extends Vehiculo {

    private double seguro;

    public Moto(String marca, String modelo, String placa,
                double tarifaDiaria, double seguro) {

        super(marca, modelo, placa, tarifaDiaria);
        this.seguro = seguro;
    }

    @Override
    public double calcularCosto(int dias) {
        return (getTarifaDiaria() * dias) + seguro;
    }
}