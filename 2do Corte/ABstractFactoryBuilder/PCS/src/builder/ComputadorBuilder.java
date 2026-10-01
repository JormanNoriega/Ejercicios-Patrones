package builder;

import domain.computador.Computador;

public interface ComputadorBuilder {

    ComputadorBuilder conProcesador();

    ComputadorBuilder conMemoria();

    ComputadorBuilder conAlmacenamiento();

    ComputadorBuilder conGrafica();

    Computador build();
}
