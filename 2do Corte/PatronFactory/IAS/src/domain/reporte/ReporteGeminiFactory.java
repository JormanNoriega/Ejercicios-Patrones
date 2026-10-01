package domain.reporte;

public class ReporteGeminiFactory extends ReporteFactory {

    @Override
    public Reporte crear() {
        return new ReporteGemini();
    }
}
