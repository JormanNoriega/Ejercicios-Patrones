# Diagrama de clases — Factory Method

Patrón aplicado: **Factory Method**. Cada producto tiene su jerarquía de creadores;
la subclase concreta decide qué producto se instancia (sin `switch` en la fábrica).

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

    class ClienteService {
        -Proveedor proveedor
        +ClienteService(Proveedor)
        +getProveedor() Proveedor
        +consultar() String
        +reporte() String
        +notificacion() String
    }

    class ConsultarService {
        -ConsultarFactory factory
        +ConsultarService(ConsultarFactory)
        +consultar() String
    }

    class ReporteService {
        -ReporteFactory factory
        +ReporteService(ReporteFactory)
        +generarReporte() String
    }

    class NotificacionService {
        -NotificacionFactory factory
        +NotificacionService(NotificacionFactory)
        +enviar() String
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

    class ConsultarFactory {
        <<abstract>>
        +crear() Consultar
    }
    class ConsultarGrokFactory {
        +crear() Consultar
    }
    class ConsultarGeminiFactory {
        +crear() Consultar
    }

    class ReporteFactory {
        <<abstract>>
        +crear() Reporte
    }
    class ReporteGrokFactory {
        +crear() Reporte
    }
    class ReporteGeminiFactory {
        +crear() Reporte
    }

    class NotificacionFactory {
        <<abstract>>
        +crear() Notificacion
    }
    class NotificacionGrokFactory {
        +crear() Notificacion
    }
    class NotificacionGeminiFactory {
        +crear() Notificacion
    }

    %% Implementaciones de producto
    ConsultarGrok ..|> Consultar
    ConsultarGemini ..|> Consultar
    ReporteGrok ..|> Reporte
    ReporteGemini ..|> Reporte
    NotificacionGrok ..|> Notificacion
    NotificacionGemini ..|> Notificacion

    %% Creadores concretos
    ConsultarGrokFactory --|> ConsultarFactory
    ConsultarGeminiFactory --|> ConsultarFactory
    ReporteGrokFactory --|> ReporteFactory
    ReporteGeminiFactory --|> ReporteFactory
    NotificacionGrokFactory --|> NotificacionFactory
    NotificacionGeminiFactory --|> NotificacionFactory

    %% Factory Method: cada creador crea su producto
    ConsultarGrokFactory ..> ConsultarGrok : crea
    ConsultarGeminiFactory ..> ConsultarGemini : crea
    ReporteGrokFactory ..> ReporteGrok : crea
    ReporteGeminiFactory ..> ReporteGemini : crea
    NotificacionGrokFactory ..> NotificacionGrok : crea
    NotificacionGeminiFactory ..> NotificacionGemini : crea

    %% Flujo del cliente
    App ..> ClienteService : usa
    App ..> Proveedor : usa
    ClienteService o-- ConsultarService
    ClienteService o-- ReporteService
    ClienteService o-- NotificacionService
    ClienteService ..> Proveedor : usa
    ConsultarService ..> ConsultarFactory : recibe
    ReporteService ..> ReporteFactory : recibe
    NotificacionService ..> NotificacionFactory : recibe
```

> Nota: `ClienteService` es el *composition root*; mapea `Proveedor` a los
> creadores concretos (`ConsultarGrokFactory`, etc.) y se los inyecta a los services.
