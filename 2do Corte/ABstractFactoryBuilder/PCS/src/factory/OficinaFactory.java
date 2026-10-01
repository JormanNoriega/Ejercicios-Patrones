package factory;

import builder.ComputadorBuilder;
import domain.almacenamiento.Almacenamiento;
import domain.almacenamiento.AlmacenamientoOficina;
import domain.computador.Computador;
import domain.grafica.TarjetaGrafica;
import domain.grafica.TarjetaGraficaOficina;
import domain.memoria.Memoria;
import domain.memoria.MemoriaOficina;
import domain.procesador.Procesador;
import domain.procesador.ProcesadorOficina;

public class OficinaFactory implements ComputadorFactory, ComputadorBuilder {

    private final Computador computador = new Computador();

    @Override
    public Procesador crearProcesador() {
        return new ProcesadorOficina();
    }

    @Override
    public Memoria crearMemoria() {
        return new MemoriaOficina();
    }

    @Override
    public Almacenamiento crearAlmacenamiento() {
        return new AlmacenamientoOficina();
    }

    @Override
    public TarjetaGrafica crearGrafica() {
        return new TarjetaGraficaOficina();
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
