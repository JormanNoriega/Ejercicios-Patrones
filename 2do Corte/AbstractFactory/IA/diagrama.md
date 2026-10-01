# Diagrama de clases — Abstract Factory (fábrica de fábricas)

Patrón aplicado: **Abstract Factory**. Una sola fábrica (`IAFactory`) crea la
**familia completa** de productos coherentes. `FactoryProducer` fabrica fábricas.

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
    }

    class IAFactory {
        <<interface>>
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
    }

    class GrokFactory {
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
    }
    class GeminiFactory {
        +crearConsultar() Consultar
        +crearReporte() Reporte
        +crearNotificacion() Notificacion
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

    %% Fábricas concretas
    GrokFactory ..|> IAFactory
    GeminiFactory ..|> IAFactory

    %% Productos concretos
    ConsultarGrok ..|> Consultar
    ConsultarGemini ..|> Consultar
    ReporteGrok ..|> Reporte
    ReporteGemini ..|> Reporte
    NotificacionGrok ..|> Notificacion
    NotificacionGemini ..|> Notificacion

    %% Fábrica de fábricas
    FactoryProducer ..> Proveedor : usa
    FactoryProducer ..> GrokFactory : crea
    FactoryProducer ..> GeminiFactory : crea
    FactoryProducer ..> IAFactory : devuelve

    %% Cada fábrica crea su familia completa
    GrokFactory ..> ConsultarGrok : crea
    GrokFactory ..> ReporteGrok : crea
    GrokFactory ..> NotificacionGrok : crea
    GeminiFactory ..> ConsultarGemini : crea
    GeminiFactory ..> ReporteGemini : crea
    GeminiFactory ..> NotificacionGemini : crea

    %% Cliente
    App ..> Proveedor : usa
    App ..> FactoryProducer : usa
    App ..> IAFactory : usa
```

> Nota: `App` sólo conoce `IAFactory` (abstracción) y `FactoryProducer`.
> La familia la selecciona una clase concreta por herencia, no un `switch` en la fábrica.
