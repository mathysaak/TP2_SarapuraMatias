package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = precargarProductos();

        int opcion;
        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 - Mostrar productos");
                System.out.println("2 - Realizar compra");
                System.out.println("3 - Salir");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                        realizarCompra(productos, scanner);
                        break;
                    case 3:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next(); 
                opcion = 0; 
            }
        } while (opcion != 3);
        scanner.close();
    }

    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("111", "Mouse", 5000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("222", "Teclado", 15000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
        productos.add(new Producto("333", "Monitor", 80000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("444", "Notebook", 850000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("555", "Webcam", 3000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        return productos;
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getEstado()) {
                System.out.println((i + 1) + " - " + producto.getDescripcion() + " - Precio: $" + producto.getPrecioUnitario());
            }
        }
    }

    private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double totalCompra = 0.0;

        System.out.println("Productos disponibles:");
        mostrarProductos(productos);

        System.out.println("Seleccione los productos que desea comprar (ingrese el número de producto, 0 para finalizar):");
        int opcionProducto;
        do {
            try {
                opcionProducto = scanner.nextInt();
                if (opcionProducto > 0 && opcionProducto <= productos.size()) {
                    Producto productoSeleccionado = productos.get(opcionProducto - 1);
                    if (productoSeleccionado.getEstado()) {
                        productosSeleccionados.add(productoSeleccionado);
                        totalCompra += productoSeleccionado.getPrecioUnitario();
                        System.out.println("Producto agregado a la compra: " + productoSeleccionado.getDescripcion());
                    } else {
                        System.out.println("El producto seleccionado no está disponible.");
                    }
                } else if (opcionProducto != 0) {
                    System.out.println("Número de producto no válido.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next(); 
                opcionProducto = 0;
            }
        } while (opcionProducto != 0);

        System.out.println("Total de la compra: $" + totalCompra);
        System.out.println("Seleccione la forma de pago:");
        System.out.println("1 - Pago en efectivo");
        System.out.println("2 - Pago con tarjeta");
        int opcionPago = scanner.nextInt();

        switch (opcionPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now());
                pagoEfectivo.realizarPago(totalCompra);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                System.out.print("Ingrese el número de tarjeta: ");
                String numeroTarjeta = scanner.next();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now());
                pagoTarjeta.realizarPago(totalCompra);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opción de pago no válida.");
        }
    }
}


