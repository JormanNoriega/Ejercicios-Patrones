# PCS — Abstract Factory + Builder + Director

Ejemplo de computadores (Gaming / Oficina) que combina tres patrones:

- **Abstract Factory** — `ComputadorFactory` garantiza que todos los componentes
  sean de la misma familia (`GamingFactory` o `OficinaFactory`).
- **Builder** — `ComputadorBuilder` ensambla paso a paso un objeto complejo
  (`Computador`) con métodos encadenables y `build()`.
- **Director** — conoce las **recetas** de construcción (`construirCompleto()`,
  `construirSinGrafica()`) y las ejecuta sobre cualquier builder.

Las fábricas concretas cumplen doble rol (`ComputadorFactory` + `ComputadorBuilder`):
reutilizan sus propios `crear...()` para armar el `Computador` sin mezclar familias.

## Estructura

```
src/
├── App.java
├── builder/
│   ├── ComputadorBuilder.java
│   └── Director.java
├── domain/
│   ├── TipoPC.java
│   ├── procesador/     Procesador, ProcesadorGaming, ProcesadorOficina
│   ├── memoria/        Memoria, MemoriaGaming, MemoriaOficina
│   ├── almacenamiento/ Almacenamiento, AlmacenamientoGaming, AlmacenamientoOficina
│   ├── grafica/        TarjetaGrafica, TarjetaGraficaGaming, TarjetaGraficaOficina
│   └── computador/     Computador
└── factory/
    ├── ComputadorFactory.java
    ├── GamingFactory.java
    ├── OficinaFactory.java
    └── FactoryProducer.java
```

## Ejecutar

```
javac -d bin (todos los .java de src)
java -cp bin App
```

Ver `diagrama.md` para el diagrama de clases (Mermaid).
