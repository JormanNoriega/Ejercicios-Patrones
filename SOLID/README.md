# Ejemplos basicos de SOLID

Este proyecto contiene ejemplos sencillos en Java sobre los cinco principios
SOLID. Todos utilizan situaciones de una tienda para que sean faciles de
relacionar durante una exposicion.

## Principios

| Principio | Ejemplo | Idea principal |
| --- | --- | --- |
| S - Responsabilidad unica | Pedido | Cada clase tiene una sola responsabilidad. |
| O - Abierto/cerrado | Metodos de pago | Se pueden agregar formas de pago sin modificar las existentes. |
| L - Sustitucion de Liskov | Empleados | Una subclase puede usarse donde se espera la clase padre. |
| I - Segregacion de interfaces | Empleados y robots | Una clase no implementa metodos que no necesita. |
| D - Inversion de dependencias | Notificaciones | Se depende de una interfaz y no de una clase concreta. |

## Estructura

```text
src/
├── App.java
└── solid/
    ├── s/
    ├── o/
    ├── l/
    ├── i/
    └── d/
```

Cada carpeta contiene una clase `Main` independiente y ejecutable. También
incluye `EjemploIncorrecto.java`, donde se muestra el problema antes de
aplicar el principio.

## Compilacion y ejecucion

Desde la carpeta principal del proyecto:

```bash
javac --release 11 -d bin src/App.java src/solid/s/*.java src/solid/o/*.java src/solid/l/*.java src/solid/i/*.java src/solid/d/*.java
java -cp bin solid.s.Main
java -cp bin solid.o.Main
java -cp bin solid.l.Main
java -cp bin solid.i.Main
java -cp bin solid.d.Main
```

Para ejecutar el resumen general:

```bash
java -cp bin App
```
