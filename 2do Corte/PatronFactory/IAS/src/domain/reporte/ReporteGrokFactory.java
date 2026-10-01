package domain.reporte;

public class ReporteGrokFactory extends ReporteFactory {

    @Override
    public Reporte crear() {
        return new ReporteGrok();
    }
}
