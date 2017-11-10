package org.umg.manejador;

import java.util.ArrayList;

import org.umg.bean.CartItem;
import org.umg.bean.Producto;

public class ManejadorCarrito {
	public static ManejadorCarrito INSTANCIA = new ManejadorCarrito();
	public static ArrayList<CartItem> listaCarrito = new ArrayList<CartItem>();
	
	public String getTotal() {
		float total = 0;
		for(CartItem item : listaCarrito) {
			total += (item.getCantidad() * item.getProducto().getPrecio());
		}
		return Float.toString(total);
	}
	
	public void deleteFromCart(String idProducto) {
		for(CartItem item : listaCarrito) {
			if(item.getProducto().getIdProducto().toString().equals(idProducto)) {
				listaCarrito.remove(item);
				break;
			}
		}
	}
}
