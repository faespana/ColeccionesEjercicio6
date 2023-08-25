package productoapp;

import productoapp.services.ProductoService;

public class ProductoAPP {

    public static void main(String[] args) {
        ProductoService ps = new ProductoService();
        
        ps.agregarProducto();
        ps.mostrarProductos();
        
        //ps.actualizarProducto();
        //ps.mostrarProductos();
        
        ps.eliminarProducto();
        ps.mostrarProductos();
    }
    
}
