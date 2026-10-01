package builder;

import domain.computador.Computador;

public class Director {

    private final ComputadorBuilder builder;

    public Director(ComputadorBuilder builder) {
        this.builder = builder;
    }

    public Computador construirCompleto() {
        return builder
                .conProcesador()
                .conMemoria()
                .conAlmacenamiento()
                .conGrafica()
                .build();
    }

    public Computador construirSinGrafica() {
        return builder
                .conProcesador()
                .conMemoria()
                .conAlmacenamiento()
                .build();
    }
}
