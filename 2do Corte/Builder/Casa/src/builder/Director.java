package builder;

import domain.Casa;

public class Director {

    private final ICasaBuilder builder;

    public Director(ICasaBuilder builder) {
        this.builder = builder;
    }

    public Casa casaBasica() {
        return builder
                .conParedes()
                .conPuertas()
                .conVentanas()
                .conTecho()
                .conPisos(1)
                .build();
    }

    public Casa casaGrande() {
        return builder
                .conParedes()
                .conPuertas()
                .conVentanas()
                .conTecho()
                .conPisos(2)
                .conGaraje()
                .conPiscina()
                .conJardin()
                .build();
    }

    public Casa casaModerna() {
        return builder
                .conParedes()
                .conPuertas()
                .conVentanas()
                .conTecho()
                .conPisos(1)
                .conPiscina()
                .conTerraza()
                .build();
    }
}
