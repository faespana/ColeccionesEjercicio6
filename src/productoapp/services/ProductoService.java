package productoapp.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import productoapp.entities.Producto;

public class ProductoService {

    private final Scanner leer;
    private final HashMap<String, Double> productos;

    public ProductoService() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.productos = new HashMap();
    }

    public Producto crearProducto() {
        Producto prod = new Producto();

        System.out.print("Ingrese el nombre del producto: ");
        prod.setNombre(leer.next());

        System.out.println("");

        System.out.print("Ingrese el precio: ");
        prod.setPrecio(leer.nextDouble());

        return prod;
    }

    public void agregarDatosProducto(Producto prod) {
        productos.put(prod.getNombre(), prod.getPrecio());
    }

    public void agregarProducto() {
        boolean bandera = true;
        int aux;

        agregarDatosProducto(crearProducto());

        while (bandera) {
            System.out.println("");
            System.out.println("Desea agregar un nuevo producto: \n1. Si \n2. No");
            aux = leer.nextInt();
            System.out.println("");
            if (aux == 1) {
                agregarDatosProducto(crearProducto());
            } else {
                bandera = false;
            }
        }
    }

    public void actualizarProducto() {
        String prodAux;
        Double priceAux;

        System.out.println("");
        System.out.print("Ingrese el nombre del producto que desea actualizar: ");
        prodAux = leer.next();

        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(prodAux)) {
                System.out.println("");
                System.out.print("Ingrese el nuevo precio del producto: ");
                priceAux = leer.nextDouble();
                System.out.println("");
                entry.setValue(priceAux);
                return;
            }

        }
        System.out.println("El producto no ha sido encontrado");
        System.out.println("");
    }

    public void eliminarProducto() {
        String prodAux;

        System.out.println("");
        System.out.print("Ingrese el nombre del producto que desea eliminar: ");
        prodAux = leer.next();
        System.out.println("");
        
        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(prodAux)) {
                productos.remove(entry.getKey());
                System.out.println("El pruducto ha sido eliminado con exito");
                System.out.println("");
                return;
            }}
        System.out.println("El producto no ha sido encontrado");
        System.out.println("");
    }

    public void mostrarProductos() {
        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            System.out.println("Nombre del producto: " + entry.getKey() + ", Precio del producto: $" + entry.getValue());
        }
    }
}
