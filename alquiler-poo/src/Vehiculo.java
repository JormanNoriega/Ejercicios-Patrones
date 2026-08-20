public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private String placa;
    private double tarifaDiaria;

    public Vehiculo(String marca, String modelo, String placa, double tarifaDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tarifaDiaria = tarifaDiaria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public abstract double calcularCosto(int dias);

    public void mostrarInformacion() {
        System.out.println("Vehículo: " + marca + " " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Tarifa diaria: $" + tarifaDiaria);
    }
}