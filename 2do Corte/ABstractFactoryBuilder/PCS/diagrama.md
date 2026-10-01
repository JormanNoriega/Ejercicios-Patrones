# Diagrama de clases — Abstract Factory + Builder + Director

Patrones aplicados:

- **Abstract Factory**: `ComputadorFactory` crea la **familia completa** de
  componentes coherentes. `FactoryProducer` fabrica fábricas.
- **Builder**: `ComputadorBuilder` ensambla paso a paso el objeto complejo `Computador`.
- **Director**: conoce las **recetas** de construcción y las ejecuta sobre cualquier
  `ComputadorBuilder`.

Las fábricas concretas (`GamingFactory`, `OficinaFactory`) cumplen **dos roles**: son
`ComputadorFactory` (crean componentes individuales) y `ComputadorBuilder` (ensamblan
el `Computador` reutilizando sus propios `crear...()`, sin mezclar familias).

```mermaid
classDiagram
    direction LR

    class App {
        +main(args) void
    }

    class TipoPC {
        <<enumeration>>
        GAMING
        OFICINA
    }

    class FactoryProducer {
        +crear(TipoPC) ComputadorFactory
        +crearBuilder(TipoPC) ComputadorBuilder
    }

    class ComputadorFactory {
        <<interface>>
        +crearProcesador() Procesador
        +crearMemoria() Memoria
        +crearAlmacenamiento() Almacenamiento
        +crearGrafica() TarjetaGrafica
    }

    class ComputadorBuilder {
        <<interface>>
        +conProcesador() ComputadorBuilder
        +conMemoria() ComputadorBuilder
        +conAlmacenamiento() ComputadorBuilder
        +conGrafica() ComputadorBuilder
        +build() Computador
    }

    class Director {
        -builder ComputadorBuilder
        +construirCompleto() Computador
        +construirSinGrafica() Computador
    }

    class GamingFactory {
        +crearProcesador() Procesador
        +crearMemoria() Memoria
        +crearAlmacenamiento() Almacenamiento
        +crearGrafica() TarjetaGrafica
        +conProcesador() ComputadorBuilder
        +conMemoria() ComputadorBuilder
        +conAlmacenamiento() ComputadorBuilder
        +conGrafica() ComputadorBuilder
        +build() Computador
    }
    class OficinaFactory {
        +crearProcesador() Procesador
        +crearMemoria() Memoria
        +crearAlmacenamiento() Almacenamiento
        +crearGrafica() TarjetaGrafica
        +conProcesador() ComputadorBuilder
        +conMemoria() ComputadorBuilder
        +conAlmacenamiento() ComputadorBuilder
        +conGrafica() ComputadorBuilder
        +build() Computador
    }

    class Computador {
        -procesador Procesador
        -memoria Memoria
        -almacenamiento Almacenamiento
        -tarjetaGrafica TarjetaGrafica
        +setProcesador(Procesador) void
        +setMemoria(Memoria) void
        +setAlmacenamiento(Almacenamiento) void
        +setTarjetaGrafica(TarjetaGrafica) void
        +mostrarConfiguracion() String
    }

    class Procesador {
        <<interface>>
        +descripcion() String
    }
    class ProcesadorGaming {
        +descripcion() String
    }
    class ProcesadorOficina {
        +descripcion() String
    }

    class Memoria {
        <<interface>>
        +descripcion() String
    }
    class MemoriaGaming {
        +descripcion() String
    }
    class MemoriaOficina {
        +descripcion() String
    }

    class Almacenamiento {
        <<interface>>
        +descripcion() String
    }
    class AlmacenamientoGaming {
        +descripcion() String
    }
    class AlmacenamientoOficina {
        +descripcion() String
    }

    class TarjetaGrafica {
        <<interface>>
        +descripcion() String
    }
    class TarjetaGraficaGaming {
        +descripcion() String
    }
    class TarjetaGraficaOficina {
        +descripcion() String
    }

    %% Fábricas concretas: dos roles (Factory + Builder)
    GamingFactory ..|> ComputadorFactory
    GamingFactory ..|> ComputadorBuilder
    OficinaFactory ..|> ComputadorFactory
    OficinaFactory ..|> ComputadorBuilder

    %% Componentes concretos
    ProcesadorGaming ..|> Procesador
    ProcesadorOficina ..|> Procesador
    MemoriaGaming ..|> Memoria
    MemoriaOficina ..|> Memoria
    AlmacenamientoGaming ..|> Almacenamiento
    AlmacenamientoOficina ..|> Almacenamiento
    TarjetaGraficaGaming ..|> TarjetaGrafica
    TarjetaGraficaOficina ..|> TarjetaGrafica

    %% Fábrica de fábricas / de builders
    FactoryProducer ..> TipoPC : usa
    FactoryProducer ..> GamingFactory : crea
    FactoryProducer ..> OficinaFactory : crea
    FactoryProducer ..> ComputadorFactory : devuelve
    FactoryProducer ..> ComputadorBuilder : devuelve

    %% Cada fábrica crea su familia completa
    GamingFactory ..> ProcesadorGaming : crea
    GamingFactory ..> MemoriaGaming : crea
    GamingFactory ..> AlmacenamientoGaming : crea
    GamingFactory ..> TarjetaGraficaGaming : crea
    OficinaFactory ..> ProcesadorOficina : crea
    OficinaFactory ..> MemoriaOficina : crea
    OficinaFactory ..> AlmacenamientoOficina : crea
    OficinaFactory ..> TarjetaGraficaOficina : crea

    %% El builder ensambla el producto complejo
    GamingFactory ..> Computador : ensambla
    OficinaFactory ..> Computador : ensambla
    Computador o-- Procesador
    Computador o-- Memoria
    Computador o-- Almacenamiento
    Computador o-- TarjetaGrafica

    %% Director usa la abstracción del builder
    Director o-- ComputadorBuilder
    Director ..> Computador : construye

    %% Cliente
    App ..> TipoPC : usa
    App ..> FactoryProducer : usa
    App ..> ComputadorFactory : usa
    App ..> ComputadorBuilder : usa
    App ..> Director : usa
    App ..> Computador : usa
```

> Nota: `App` sólo conoce las abstracciones (`ComputadorFactory`, `ComputadorBuilder`),
> el `FactoryProducer` y el `Director`. La familia la elige la fábrica concreta; la
> receta la define el `Director`; el paso a paso lo hace la fábrica concreta en su rol
> de `Builder`, reutilizando `crear...()` para no mezclar componentes de otra familia.
