package solid.i;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        empleado.trabajar();
        empleado.comer();
        empleado.descansar();

        Robot robot = new Robot();
        robot.trabajar();
    }
}
