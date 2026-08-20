package solid.i;

public class EjemploIncorrecto {
    public static void main(String[] args) {
        new RobotIncorrecto().trabajar();
    }
}

interface TrabajadorIncorrecto {
    void trabajar();
    void comer();
    void descansar();
}

class RobotIncorrecto implements TrabajadorIncorrecto {
    public void trabajar() {
        System.out.println("El robot esta trabajando");
    }

    public void comer() {
        // Un robot no necesita este metodo.
    }

    public void descansar() {
        // Un robot no necesita este metodo.
    }
}
