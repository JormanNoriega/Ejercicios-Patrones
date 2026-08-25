# Ejemplos de SOLID en Java

Proyecto educativo con ejemplos ejecutables de los cinco principios SOLID.
Cada principio incluye un caso incorrecto y una solución sencilla.

## Principios

| Principio | Ejemplo | Qué se demuestra |
| --- | --- | --- |
| S - Responsabilidad única | Pedido | El pedido, el cálculo y la persistencia tienen responsabilidades separadas. |
| O - Abierto/cerrado | Métodos de pago | `ProcesadorPago` trabaja con nuevos medios mediante `MetodoPago`. |
| L - Sustitución de Liskov | Empleados | Todos los tipos de empleado pueden sustituir a `Empleado`. |
| I - Segregación de interfaces | Empleados y robots | Cada clase implementa solo las capacidades que necesita. |
| D - Inversión de dependencias | Notificaciones | `PedidoService` depende de `Notificador`, no de un canal concreto. |

## Estructura

```text
src/
└── main/java/     # Aplicación y ejemplos SOLID
```

Los archivos `EjemploIncorrecto.java` muestran el problema antes de aplicar
cada principio. Las clases `Main.java` muestran la solución.

## Requisitos

- JDK 11 o superior

## Compilación

Desde la carpeta del proyecto:

```bash
javac --release 11 -d bin src/main/java/App.java src/main/java/solid/s/*.java src/main/java/solid/o/*.java src/main/java/solid/l/*.java src/main/java/solid/i/*.java src/main/java/solid/d/*.java
```

## Ejecución de demostraciones

```bash
java -cp bin solid.s.Main
java -cp bin solid.o.Main
java -cp bin solid.l.Main
java -cp bin solid.i.Main
java -cp bin solid.d.Main
java -cp bin App
```

Los importes usan `BigDecimal` en el ejercicio de pedidos para evitar errores
de precisión habituales al representar dinero con `double`.
