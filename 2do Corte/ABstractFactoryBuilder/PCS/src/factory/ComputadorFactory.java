package factory;

import domain.almacenamiento.Almacenamiento;
import domain.grafica.TarjetaGrafica;
import domain.memoria.Memoria;
import domain.procesador.Procesador;

public interface ComputadorFactory {

    Procesador crearProcesador();

    Memoria crearMemoria();

    Almacenamiento crearAlmacenamiento();

    TarjetaGrafica crearGrafica();
}
