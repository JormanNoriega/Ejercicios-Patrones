# Diagrama de clases — Abstract Factory + Builder + Director

Patrones aplicados:

- **Abstract Factory**: `IAFactory` crea la **familia completa** de productos
  coherentes. `FactoryProducer` fabrica fábricas.
- **Builder**: `IABuilder` ensambla paso a paso un objeto complejo `PaqueteIA`.
- **Director**: conoce las **recetas** de construcción y las ejecuta sobre cualquier `IABuilder`.

Las fábricas concretas (`GrokFactory`, `GeminiFactory`) cumplen **dos roles**: son
`IAFactory` (crean productos individuales) y `IABuilder` (ensamblan el `PaqueteIA`
reutilizando sus propios métodos `crear...()`, sin mezclar familias).

```mermaid
classDiagram
    direction LR

    class App {
        +main(args) void
    }

    class Proveedor {
        <<enumeration>>
        GROK
        GEMINI
    }

    class FactoryProducer {
        +crear(Proveedor) IAFactory
        +crearBuilder(Proveedor) IABuilder
    }

    class IAFactory {
        <<interface>>
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
    }

    class IABuilder {
        <<interface>>
        +conConsultar() IABuilder
        +conReporte() IABuilder
        +conNotificacion() IABuilder
        +build() PaqueteIA
    }

    class Director {
        -builder IABuilder
        +construirPaqueteCompleto() PaqueteIA
        +construirSoloConsulta() PaqueteIA
        +construirConsultaYReporte() PaqueteIA
    }

    class GrokFactory {
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
        +conConsultar() IABuilder
        +conReporte() IABuilder
        +conNotificacion() IABuilder
        +build() PaqueteIA
    }
    class GeminiFactory {
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
        +conConsultar() IABuilder
        +conReporte() IABuilder
        +conNotificacion() IABuilder
        +build() PaqueteIA
    }

    class PaqueteIA {
        -consultar Consultar
        -reporte Reporte
        -notificacion Notificacion
        +setConsultar(Consultar) void
        +setReporte(Reporte) void
        +setNotificacion(Notificacion) void
        +ejecutarTodo() String
    }

    class Consultar {
        <<interface>>
        +consultar() String
    }
    class ConsultarGrok {
        +consultar() String
    }
    class ConsultarGemini {
        +consultar() String
    }

    class Reporte {
        <<interface>>
        +generarReporte() String
    }
    class ReporteGrok {
        +generarReporte() String
    }
    class ReporteGemini {
        +generarReporte() String
    }

    class Notificacion {
        <<interface>>
        +enviar() String
    }
    class NotificacionGrok {
        +enviar() String
    }
    class NotificacionGemini {
        +enviar() String
    }

    %% Fábricas concretas: dos roles (Factory + Builder)
    GrokFactory ..|> IAFactory
    GrokFactory ..|> IABuilder
    GeminiFactory ..|> IAFactory
    GeminiFactory ..|> IABuilder

    %% Productos concretos
    ConsultarGrok ..|> Consultar
    ConsultarGemini ..|> Consultar
    ReporteGrok ..|> Reporte
    ReporteGemini ..|> Reporte
    NotificacionGrok ..|> Notificacion
    NotificacionGemini ..|> Notificacion

    %% Fábrica de fábricas / de builders
    FactoryProducer ..> Proveedor : usa
    FactoryProducer ..> GrokFactory : crea
    FactoryProducer ..> GeminiFactory : crea
    FactoryProducer ..> IAFactory : devuelve
    FactoryProducer ..> IABuilder : devuelve

    %% Cada fábrica crea su familia completa
    GrokFactory ..> ConsultarGrok : crea
    GrokFactory ..> ReporteGrok : crea
    GrokFactory ..> NotificacionGrok : crea
    GeminiFactory ..> ConsultarGemini : crea
    GeminiFactory ..> ReporteGemini : crea
    GeminiFactory ..> NotificacionGemini : crea

    %% El builder ensambla el producto complejo
    GrokFactory ..> PaqueteIA : ensambla
    GeminiFactory ..> PaqueteIA : ensambla
    PaqueteIA o-- Consultar
    PaqueteIA o-- Reporte
    PaqueteIA o-- Notificacion

    %% Director usa la abstracción del builder
    Director o-- IABuilder
    Director ..> PaqueteIA : construye

    %% Cliente
    App ..> Proveedor : usa
    App ..> FactoryProducer : usa
    App ..> IAFactory : usa
    App ..> IABuilder : usa
    App ..> Director : usa
    App ..> PaqueteIA : usa
```

> Nota: `App` sólo conoce las abstracciones (`IAFactory`, `IABuilder`), el
> `FactoryProducer` y el `Director`. La familia la selecciona una clase concreta
> por herencia; la receta la define el `Director`; el paso a paso lo hace la
> fábrica concreta en su rol de `Builder`, reutilizando `crear...()` para no
> mezclar productos de distintas familias.
