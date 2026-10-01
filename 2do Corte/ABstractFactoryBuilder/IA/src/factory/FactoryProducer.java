package factory;

import builder.IABuilder;
import domain.Proveedor;

public class FactoryProducer {

    public static IAFactory crear(Proveedor proveedor) {
        switch (proveedor) {
            case GROK:
                return new GrokFactory();
            case GEMINI:
                return new GeminiFactory();
            default:
                throw new IllegalArgumentException("Proveedor desconocido: " + proveedor);
        }
    }

    public static IABuilder crearBuilder(Proveedor proveedor) {
        return (IABuilder) crear(proveedor);
    }
}
