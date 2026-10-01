package domain.consultar;

public class ConsultarGeminiFactory extends ConsultarFactory {

    @Override
    public Consultar crear() {
        return new ConsultarGemini();
    }
}
