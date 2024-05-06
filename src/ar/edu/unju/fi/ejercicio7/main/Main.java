package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = precargarProductos();

        int opcion;
        try {
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Mostrar productos faltantes");
            System.out.println("3 - Incrementar precios de productos en un 20%");
            System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio descendente");
            System.out.println("6 - Mostrar nombres de productos en mayúsculas");
            System.out.println("7 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();


                switch (opcion) {
                    case 1:
                        mostrarProductos(productos, p -> System.out.println(p));
                        break;
                    case 2:
                        mostrarProductosFaltantes(productos);
                        break;
                    case 3:
                        ArrayList<Producto> productosIncrementados = incrementarPrecios(productos);
                        mostrarProductos(productosIncrementados, p -> System.out.println(p));
                        break;
                    case 4:
                        mostrarProductosCategoria(productos, "Electrohogar");
                        break;
                    case 5:
                        ordenarProductosPorPrecioDescendente(productos);
                        mostrarProductos(productos, p -> System.out.println(p));
                        break;
                    case 6:
                        mostrarNombresEnMayusculas(productos);
                        break;
                    case 7:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }

        } while (opcion != 7);
    } catch (Exception e) {
        System.out.println("Ingresa una opcion validad.");
    }
        scanner.close();
    }

    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("111", "Mouse", 5000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("222", "Teclado", 15000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
        productos.add(new Producto("333", "Monitor", 80000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("444", "Notebook", 850000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("555", "Webcam", 3000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("110", "Motorola 1", 50000.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("220", "Samsaung Tablet", 1500000.0, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
        productos.add(new Producto("330", "Cargador Portatil", 8000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("440", "USB C", 5000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("550", "Iphone 7", 333000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("110", "Heladera", 500000.0, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("220", "Aire Acondicionado", 1005000.0, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("330", "Smart TV", 800000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("440", "Ventilador", 50000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("550", "Alarma", 30000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));

        return productos;
    }

    private static void mostrarProductos(ArrayList<Producto> productos, Consumer<Producto> consumer) {
        System.out.println("Productos disponibles:");
        productos.stream()
                .filter(p -> p.getEstado())
                .forEach(consumer);
    }

    private static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
        System.out.println("Productos faltantes:");
        productos.stream()
                .filter(p -> !p.getEstado())
                .forEach(System.out::println);
    }

    private static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> productos) {
        System.out.println("Precios incrementados:");
        return productos.stream()
                .map(p -> new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecioUnitario() * 1.20, p.getOrigenFabricacion(), p.getCategoria(), p.getEstado()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }


	private static void mostrarProductosCategoria(ArrayList<Producto> productos, String categoria) {
        System.out.println("Productos de la categoría " + categoria + " disponibles:");
        productos.stream()
                .filter(p -> p.getCategoria().equals(categoria) && p.getEstado())
                .forEach(System.out::println);
    }

	private static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos) {
	    System.out.println("Productos ordenados por precio descendente:");
	    productos.sort(new Comparator<Producto>() {
	        @Override
	        public int compare(Producto p1, Producto p2) {
	            return Double.compare(p2.getPrecioUnitario(), p1.getPrecioUnitario());
	        }
	    });
	}


    private static void mostrarNombresEnMayusculas(ArrayList<Producto> productos) {
        System.out.println("Nombres de productos en mayúsculas:");
        productos.stream()
                .map(p -> p.getDescripcion().toUpperCase())
                .forEach(nombre -> System.out.println(nombre));
    }
}

