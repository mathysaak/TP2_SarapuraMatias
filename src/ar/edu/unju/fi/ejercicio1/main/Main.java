package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		ArrayList <Producto> producto_s = new ArrayList<Producto>();
		
		Producto producto1 = new Producto( OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR);
		
		producto1.setCodigo("111");
		producto1.setDescripcion("Lavarropa");
		producto1.setPrecioUnitario(100000);
		
		producto_s.add(producto1);
		
		System.out.println(producto_s.get(0).toString());
		
		//Rama princiapl
		
		
	}

}
