import java.util.List;

// ============================================================
// 1. LOS COMPONENTES (Lo que el producto "TIENE")
// ============================================================

// --- COMPONENTE DE INVENTARIO ---
interface Inventario {
    void descontar(int cantidad, String nombreProducto);
    String getStockVisual();
}

class InventarioFisico implements Inventario {
    private int stock;
    public InventarioFisico(int stock) { this.stock = stock; }
    
    @Override
    public void descontar(int cantidad, String nombreProducto) {
        if (cantidad > stock) throw new IllegalStateException("[" + nombreProducto + "] Stock insuficiente.");
        stock -= cantidad;
    }
    
    @Override
    public String getStockVisual() { return String.valueOf(stock); }
}

// Para productos digitales, el inventario existe pero es "infinito"
class InventarioInfinito implements Inventario {
    @Override
    public void descontar(int cantidad, String nombreProducto) { /* No hace nada */ }
    @Override
    public String getStockVisual() { return "Ilimitado"; }
}


// --- COMPONENTE DE IMPUESTO ---
interface Impuesto {
    double calcular(double precioBase);
}

class ImpuestoIva implements Impuesto {
    @Override
    public double calcular(double precioBase) { return precioBase * 1.19; } // 19% IVA
}

class ImpuestoExento implements Impuesto {
    @Override
    public double calcular(double precioBase) { return precioBase; } // 0% IVA
}


// --- COMPONENTE DE VENCIMIENTO ---
interface Vencimiento {
    void validarVencimiento(String nombreProducto);
}

class ConVencimiento implements Vencimiento {
    private boolean vencido;
    public ConVencimiento(boolean vencido) { this.vencido = vencido; }
    
    @Override
    public void validarVencimiento(String nombreProducto) {
        if (vencido) throw new IllegalStateException("[" + nombreProducto + "] Producto caducado.");
    }
}

class SinVencimiento implements Vencimiento {
    @Override
    public void validarVencimiento(String nombreProducto) { /* Nunca vence */ }
}

// ============================================================
// 2. LA CLASE PRODUCTO (Única clase, sin herencia)
// ============================================================

class Producto {
    private String nombre;
    private double precio;
    
    // El producto se COMPONE de estas tres características
    private Inventario inventario;
    private Impuesto impuesto;
    private Vencimiento vencimiento;

    public Producto(String nombre, double precio, Inventario inventario, Impuesto impuesto, Vencimiento vencimiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.impuesto = impuesto;
        this.vencimiento = vencimiento;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public Inventario getInventario() { return inventario; }
    public Impuesto getImpuesto() { return impuesto; }
    public Vencimiento getVencimiento() { return vencimiento; }
}

// ============================================================
// 3. EL MODELO DE VENTAS (Tu idea aplicada)
// ============================================================

class DetalleVenta {
    private Producto producto;
    private int cantidad;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    
    // Calcula el subtotal delegando al impuesto del producto
    public double getSubtotal() {
        return producto.getImpuesto().calcular(producto.getPrecio()) * cantidad;
    }
}

class VentaService {
    // El servicio orquesta la venta, pero las reglas las tienen los componentes
    public double procesarVenta(List<DetalleVenta> detalles) {
        double totalVenta = 0;
        
        System.out.println("--- INICIANDO VENTA ---");
        
        for (DetalleVenta detalle : detalles) {
            Producto p = detalle.getProducto();
            int cant = detalle.getCantidad();
            
            try {
                // 1. Validar que no esté vencido
                p.getVencimiento().validarVencimiento(p.getNombre());
                
                // 2. Descontar stock (el digital no hará nada, el físico restará)
                p.getInventario().descontar(cant, p.getNombre());
                
                // 3. Sumar al total
                double subtotal = detalle.getSubtotal();
                totalVenta += subtotal;
                
                System.out.printf("Vendido: %dx %s | Subtotal: $%.2f%n", cant, p.getNombre(), subtotal);
                
            } catch (IllegalStateException e) {
                System.out.println("No se pudo vender: " + e.getMessage());
            }
        }
        
        System.out.println("-----------------------");
        return totalVenta;
    }
}

// ============================================================
// 4. MAIN - Armando los productos como Legos
// ============================================================

public class Ejercicio4ComposicionService {
    public static void main(String[] args) {
        // Armamos un producto ESTÁNDAR
        Producto cuaderno = new Producto("Cuaderno", 5000, 
            new InventarioFisico(100), new ImpuestoIva(), new SinVencimiento());

        // Armamos un producto DIGITAL (Aquí resuelves tu duda: le pasas componentes exentos/infinitos)
        Producto cursoJava = new Producto("Curso Java", 120000, 
            new InventarioInfinito(), new ImpuestoExento(), new SinVencimiento());

        // Armamos un producto PERECIBLE
        Producto yogur = new Producto("Yogur", 3500, 
            new InventarioFisico(40), new ImpuestoIva(), new ConVencimiento(false));
            
        // Producto PERECIBLE VENCIDO
        Producto lecheVencida = new Producto("Leche", 2800, 
            new InventarioFisico(20), new ImpuestoIva(), new ConVencimiento(true));

        // Creamos los detalles de la venta (Tu idea)
        List<DetalleVenta> carrito = List.of(
            new DetalleVenta(cuaderno, 2),
            new DetalleVenta(cursoJava, 1),
            new DetalleVenta(yogur, 5),
            new DetalleVenta(lecheVencida, 1) // Este fallará por la validación
        );

        // El servicio procesa la venta
        VentaService servicio = new VentaService();
        double totalAProgramar = servicio.procesarVenta(carrito);
        
        System.out.printf("TOTAL A PAGAR: $%.2f%n", totalAProgramar);
    }
}