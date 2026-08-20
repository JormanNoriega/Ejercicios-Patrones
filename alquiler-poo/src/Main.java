public class Main {

    public static void main(String[] args) {

        Vehiculo carro = new Carro(
                "Toyota",
                "Corolla",
                "ABC123",
                100000
        );

        Vehiculo moto = new Moto(
                "Yamaha",
                "MT-03",
                "XYZ456",
                60000,
                30000
        );

        Vehiculo camion = new Camion(
                "Volvo",
                "FH",
                "DEF789",
                200000,
                50000
        );

        Alquiler alquilerCarro = new Alquiler(carro, 3);
        Alquiler alquilerMoto = new Alquiler(moto, 3);
        Alquiler alquilerCamion = new Alquiler(camion, 3);

        alquilerCarro.mostrarAlquiler();
        alquilerMoto.mostrarAlquiler();
        alquilerCamion.mostrarAlquiler();
    }
}