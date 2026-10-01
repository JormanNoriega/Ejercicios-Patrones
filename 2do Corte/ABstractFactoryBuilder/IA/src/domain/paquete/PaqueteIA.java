package domain.paquete;

import domain.consultar.Consultar;
import domain.notificacion.Notificacion;
import domain.reporte.Reporte;

public class PaqueteIA {

    private Consultar consultar;
    private Reporte reporte;
    private Notificacion notificacion;

    public void setConsultar(Consultar consultar) {
        this.consultar = consultar;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public Consultar getConsultar() {
        return consultar;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public String ejecutarTodo() {
        StringBuilder resultado = new StringBuilder();

        if (consultar != null) {
            resultado.append(consultar.consultar());
        }
        if (reporte != null) {
            agregarSalto(resultado);
            resultado.append(reporte.generarReporte());
        }
        if (notificacion != null) {
            agregarSalto(resultado);
            resultado.append(notificacion.enviar());
        }

        return resultado.toString();
    }

    private void agregarSalto(StringBuilder resultado) {
        if (resultado.length() > 0) {
            resultado.append(System.lineSeparator());
        }
    }
}
