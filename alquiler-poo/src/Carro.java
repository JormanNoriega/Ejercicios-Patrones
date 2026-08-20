public class Carro extends Vehiculo {

    public Carro(String marca, String modelo, String placa, double tarifaDiaria) {
        super(marca, modelo, placa, tarifaDiaria);
    }

    @Override
    public double calcularCosto(int dias) {
        return getTarifaDiaria() * dias;
    }
}