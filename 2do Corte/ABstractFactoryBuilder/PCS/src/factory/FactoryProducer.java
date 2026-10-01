package factory;

import builder.ComputadorBuilder;
import domain.TipoPC;

public class FactoryProducer {

    public static ComputadorFactory crear(TipoPC tipo) {
        switch (tipo) {
            case GAMING:
                return new GamingFactory();
            case OFICINA:
                return new OficinaFactory();
            default:
                throw new IllegalArgumentException("Tipo de PC desconocido: " + tipo);
        }
    }

    public static ComputadorBuilder crearBuilder(TipoPC tipo) {
        return (ComputadorBuilder) crear(tipo);
    }
}
