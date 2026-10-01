package builder;

import domain.Casa;

public class CasaBuilder implements ICasaBuilder {

    private final Casa casa = new Casa();

    @Override
    public ICasaBuilder conParedes() {
        casa.setParedes("Paredes de concreto");
        return this;
    }

    @Override
    public ICasaBuilder conPuertas() {
        casa.setPuertas("Puertas de vidrio");
        return this;
    }

    @Override
    public ICasaBuilder conVentanas() {
        casa.setVentanas("Ventanas amplias");
        return this;
    }

    @Override
    public ICasaBuilder conTecho() {
        casa.setTecho("Techo de losa");
        return this;
    }

    @Override
    public ICasaBuilder conPisos(int pisos) {
        casa.setPisos(pisos);
        return this;
    }

    @Override
    public ICasaBuilder conGaraje() {
        casa.setGaraje("Garaje doble");
        return this;
    }

    @Override
    public ICasaBuilder conPiscina() {
        casa.setPiscina("Piscina");
        return this;
    }

    @Override
    public ICasaBuilder conJardin() {
        casa.setJardin("Jardin");
        return this;
    }

    @Override
    public ICasaBuilder conTerraza() {
        casa.setTerraza("Terraza");
        return this;
    }

    @Override
    public Casa build() {
        return casa;
    }
}
