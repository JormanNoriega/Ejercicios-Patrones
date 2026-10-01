# Diagrama de clases — Builder + Director

Patrón **Builder** (GoF). El **Director** conoce las recetas (los pasos y su orden),
el **ConcreteBuilder** sabe construir cada parte y el **Product** es el resultado.

```mermaid
classDiagram
    direction LR

    class App {
        +main(args) void
    }

    class ICasaBuilder {
        <<interface>>
        +conParedes() ICasaBuilder
        +conPuertas() ICasaBuilder
        +conVentanas() ICasaBuilder
        +conTecho() ICasaBuilder
        +conPisos(int) ICasaBuilder
        +conGaraje() ICasaBuilder
        +conPiscina() ICasaBuilder
        +conJardin() ICasaBuilder
        +conTerraza() ICasaBuilder
        +build() Casa
    }

    class CasaBuilder {
        -casa Casa
        +conParedes() ICasaBuilder
        +conPuertas() ICasaBuilder
        +conVentanas() ICasaBuilder
        +conTecho() ICasaBuilder
        +conPisos(int) ICasaBuilder
        +conGaraje() ICasaBuilder
        +conPiscina() ICasaBuilder
        +conJardin() ICasaBuilder
        +conTerraza() ICasaBuilder
        +build() Casa
    }

    class Director {
        -builder ICasaBuilder
        +casaBasica() Casa
        +casaGrande() Casa
        +casaModerna() Casa
    }

    class Casa {
        -paredes String
        -puertas String
        -ventanas String
        -techo String
        -pisos int
        -garaje String
        -piscina String
        -jardin String
        -terraza String
        +mostrarCasa() String
    }

    CasaBuilder ..|> ICasaBuilder : implementa
    CasaBuilder ..> Casa : construye
    Director o-- ICasaBuilder : usa
    Director ..> Casa : recetas
    App ..> Director : usa
    App ..> CasaBuilder : crea
    App ..> Casa : usa
```

## Recetas del Director

| Receta | Partes incluidas |
|---|---|
| `casaBasica()` | paredes, puertas, ventanas, techo, pisos(1) |
| `casaGrande()` | paredes, puertas, ventanas, techo, pisos(2), garaje, piscina, jardin |
| `casaModerna()` | paredes, puertas, ventanas, techo, pisos(1), piscina, terraza |

> Nota: el mismo `CasaBuilder` construye todas las variantes; la diferencia está en la
> **receta** que ejecuta el `Director`. `App` solo decide qué receta pedir.
