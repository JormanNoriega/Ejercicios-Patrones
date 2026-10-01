# Casa — Patrón Builder + Director

Ejemplo sencillo del patrón **Builder** (GoF) con **un solo builder concreto** y un
**Director** que define varias recetas de construcción.

- **Product** — `Casa`: el objeto complejo que se construye paso a paso.
- **Builder** — `ICasaBuilder`: interfaz con los pasos de construcción.
- **ConcreteBuilder** — `CasaBuilder`: sabe cómo construir cada parte de la `Casa`.
- **Director** — `Director`: conoce las recetas (`casaBasica`, `casaGrande`, `casaModerna`)
  y ejecuta los pasos en el orden correcto sobre el builder.

## Estructura

```
src/
├── App.java
├── builder/
│   ├── ICasaBuilder.java
│   ├── CasaBuilder.java
│   └── Director.java
└── domain/
    └── Casa.java
```

## Ejecutar

```
javac -d bin (todos los .java de src)
java -cp bin App
```

Ver `diagrama.md` para el diagrama de clases (Mermaid).
