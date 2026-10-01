package factory;

import builder.ComputadorBuilder;
import domain.almacenamiento.Almacenamiento;
import domain.almacenamiento.AlmacenamientoGaming;
import domain.computador.Computador;
import domain.grafica.TarjetaGrafica;
import domain.grafica.TarjetaGraficaGaming;
import domain.memoria.Memoria;
import domain.memoria.MemoriaGaming;
import domain.procesador.Procesador;
import domain.procesador.ProcesadorGaming;

public class GamingFactory implements ComputadorFactory, ComputadorBuilder {

    private final Computador computador = new Computador();

    @Override
    public Procesador crearProcesador() {
        return new ProcesadorGaming();
    }

    @Override
    public Memoria crearMemoria() {
        return new MemoriaGaming();
    }

    @Override
    public Almacenamiento crearAlmacenamiento() {
        return new AlmacenamientoGaming();
    }

    @Override
    public TarjetaGrafica crearGrafica() {
        return new TarjetaGraficaGaming();
    }

    @Override
    public ComputadorBuilder conProcesador() {
        computador.setProcesador(crearProcesador());
        return this;
    }

    @Override
    public ComputadorBuilder conMemoria() {
        computador.setMemoria(crearMemoria());
        return this;
    }

    @Override
    public ComputadorBuilder conAlmacenamiento() {
        computador.setAlmacenamiento(crearAlmacenamiento());
        return this;
    }

    @Override
    public ComputadorBuilder conGrafica() {
        computador.setTarjetaGrafica(crearGrafica());
        return this;
    }

    @Override
    public Computador build() {
        return computador;
    }
}
