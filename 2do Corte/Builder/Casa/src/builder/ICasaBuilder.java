package builder;

import domain.Casa;

public interface ICasaBuilder {

    ICasaBuilder conParedes();

    ICasaBuilder conPuertas();

    ICasaBuilder conVentanas();

    ICasaBuilder conTecho();

    ICasaBuilder conPisos(int pisos);

    ICasaBuilder conGaraje();

    ICasaBuilder conPiscina();

    ICasaBuilder conJardin();

    ICasaBuilder conTerraza();

    Casa build();
}
