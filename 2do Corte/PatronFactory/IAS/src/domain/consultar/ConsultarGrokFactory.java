package domain.consultar;

public class ConsultarGrokFactory extends ConsultarFactory {

    @Override
    public Consultar crear() {
        return new ConsultarGrok();
    }
}
