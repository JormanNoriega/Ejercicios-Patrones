import java.util.List;

// ============================================================
//  EJERCICIO 4
//  Contexto: sistema de inventario de una tienda
//
//  Analiza el código, identifica qué problemas de diseño
//  presenta y explica cómo los corregirías.
// ============================================================

public class Ejercicio4 {

    // Clase base para todo tipo de producto
    static class Producto {
        protected String nombre;
        protected int    stock;
        protected double precio;

        Producto(String nombre, int stock, double precio) {
            this.nombre = nombre;
            this.stock  = stock;
            this.precio = precio;
        }

        // Contrato: descuenta unidades del stock si hay disponibilidad
        void vender(int unidades) {
            if (unidades > stock) {
                System.out.println("[" + nombre + "] Stock insuficiente.");
                return;
            }
            stock -= unidades;
            System.out.printf("[%s] Venta de %d unidad(es). Stock restante: %d%n",
                    nombre, unidades, stock);
        }

        // Contrato: devuelve el precio con el impuesto incluido
        double precioConImpuesto() {
            return precio * 1.19;
        }

        int getStock()       { return stock;  }
        String getNombre()   { return nombre; }
        double getPrecio()   { return precio; }
    }

    // --- Producto digital: no tiene stock físico ---

    static class ProductoDigital extends Producto {

        ProductoDigital(String nombre, double precio) {
            super(nombre, Integer.MAX_VALUE, precio); // stock "infinito"
        }

        // Sobreescribe vender() cambiando silenciosamente el contrato:
        // nunca agota stock. El cliente no sabe si vendió o no.
        @Override
        void vender(int unidades) {
            System.out.printf("[%s] Licencia digital entregada x%d (sin afectar stock).%n",
                    nombre, unidades);
        }

        // Los productos digitales están exentos de IVA,
        // pero el contrato de la clase base siempre aplica 19%.
        @Override
        double precioConImpuesto() {
            return precio; // sin IVA — rompe la expectativa del 19%
        }
    }

    // --- Producto perecedero: vencimiento afecta venta ---

    static class ProductoPerecible extends Producto {
        private boolean vencido;

        ProductoPerecible(String nombre, int stock, double precio, boolean vencido) {
            super(nombre, stock, precio);
            this.vencido = vencido;
        }

        // Sobreescribe vender() lanzando una excepción que la clase base no declara
        @Override
        void vender(int unidades) {
            if (vencido) {
                throw new IllegalStateException(
                        "[" + nombre + "] Producto vencido: no se puede vender.");
            }
            super.vender(unidades);
        }
    }

    // --- Calculadora de ingresos ---

    static class CalculadoraIngresos {

        // Calcula ingresos totales de una lista de productos.
        // Asume el contrato de Producto: vender() descuenta stock
        // y precioConImpuesto() incluye siempre el 19%.
        double calcularIngresosEsperados(List<Producto> productos, int unidadesPorProducto) {
            double total = 0;
            for (Producto p : productos) {
                try {
                    p.vender(unidadesPorProducto);
                    // Asume que el precio con impuesto siempre lleva IVA
                    total += p.precioConImpuesto() * unidadesPorProducto;
                } catch (IllegalStateException e) {
                    System.out.println("Venta omitida: " + e.getMessage());
                }
            }
            return total;
        }

        // Para generar el informe, la lógica debe saber el tipo real —
        // señal de que la jerarquía no está bien diseñada.
        void imprimirInforme(List<Producto> productos) {
            System.out.println("\n--- INFORME DE INVENTARIO ---");
            for (Producto p : productos) {

                String tipo;
                if (p instanceof ProductoDigital) {
                    tipo = "Digital";
                } else if (p instanceof ProductoPerecible) {
                    tipo = "Perecible";
                } else {
                    tipo = "Estandar";
                }

                System.out.printf("%-20s | Tipo: %-10s | Stock: %6s | Precio+IVA: $%.2f%n",
                        p.getNombre(), tipo,
                        p.getStock() == Integer.MAX_VALUE ? "ilimitado" : String.valueOf(p.getStock()),
                        p.precioConImpuesto());
            }
        }
    }

    public static void main(String[] args) {
        Producto estandar  = new Producto("Cuaderno",        100, 5000);
        Producto digital   = new ProductoDigital("Curso Java", 120000);
        Producto perecible = new ProductoPerecible("Yogur", 40, 3500, false);
        Producto vencido   = new ProductoPerecible("Leche", 20, 2800, true);

        List<Producto> inventario = List.of(estandar, digital, perecible, vencido);

        CalculadoraIngresos calc = new CalculadoraIngresos();

        System.out.println("=== Calcular ingresos (5 unidades por producto) ===");
        double total = calc.calcularIngresosEsperados(inventario, 5);
        System.out.printf("%nIngresos totales: $%.2f%n", total);

        calc.imprimirInforme(inventario);
    }
}