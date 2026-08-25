package solid.i;

public class Empleado implements Trabajable, Comible, Descansable {
    @Override
    public void trabajar() {
        System.out.println("El empleado esta trabajando");
    }

    @Override
    public void comer() {
        System.out.println("El empleado esta comiendo");
    }

    @Override
    public void descansar() {
        System.out.println("El empleado esta descansando");
    }
}
