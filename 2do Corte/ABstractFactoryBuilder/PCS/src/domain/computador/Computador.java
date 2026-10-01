package domain.computador;

import domain.almacenamiento.Almacenamiento;
import domain.grafica.TarjetaGrafica;
import domain.memoria.Memoria;
import domain.procesador.Procesador;

public class Computador {

    private Procesador procesador;
    private Memoria memoria;
    private Almacenamiento almacenamiento;
    private TarjetaGrafica tarjetaGrafica;

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public void setAlmacenamiento(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public Almacenamiento getAlmacenamiento() {
        return almacenamiento;
    }

    public TarjetaGrafica getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public String mostrarConfiguracion() {
        StringBuilder resultado = new StringBuilder();
        agregar(resultado, "Procesador", procesador == null ? null : procesador.descripcion());
        agregar(resultado, "Memoria", memoria == null ? null : memoria.descripcion());
        agregar(resultado, "Almacenamiento", almacenamiento == null ? null : almacenamiento.descripcion());
        agregar(resultado, "Tarjeta grafica", tarjetaGrafica == null ? null : tarjetaGrafica.descripcion());
        return resultado.toString();
    }

    private void agregar(StringBuilder resultado, String etiqueta, String valor) {
        if (valor == null) {
            return;
        }
        if (resultado.length() > 0) {
            resultado.append(System.lineSeparator());
        }
        resultado.append("- ").append(etiqueta).append(": ").append(valor);
    }
}
