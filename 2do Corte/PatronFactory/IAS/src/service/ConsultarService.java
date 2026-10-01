package service;

import domain.consultar.ConsultarFactory;

public class ConsultarService {

    private final ConsultarFactory factory;

    public ConsultarService(ConsultarFactory factory) {
        this.factory = factory;
    }

    public String consultar() {
        return factory.crear().consultar();
    }
}
