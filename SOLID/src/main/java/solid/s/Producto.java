package solid.s;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {
    private final String nombre;
    private final BigDecimal precio;

    public Producto(String nombre, BigDecimal precio) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio");
        this.precio = Objects.requireNonNull(precio, "El precio es obligatorio");
        if (precio.signum() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
}
