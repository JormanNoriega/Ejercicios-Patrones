package solid.i;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        asignarTrabajo(empleado);
        ofrecerComida(empleado);
        permitirDescanso(empleado);

        Robot robot = new Robot();
        asignarTrabajo(robot);
    }

    private static void asignarTrabajo(Trabajable trabajador) {
        trabajador.trabajar();
    }

    private static void ofrecerComida(Comible empleado) {
        empleado.comer();
    }

    private static void permitirDescanso(Descansable empleado) {
        empleado.descansar();
    }
}
