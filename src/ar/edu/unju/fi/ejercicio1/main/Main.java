package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        crearProducto(scanner, productos);
                        break;
                    case 2:
                        mostrarProductos(productos);
                        break;
                    case 3:
                        modificarProducto(scanner, productos);
                        break;
                    case 4:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("1 - Crear Producto");
        System.out.println("2 - Mostrar productos");
        System.out.println("3 - Modificar producto");
        System.out.println("4 - Salir");
        System.out.print("Elija una opción: ");
    }

    private static void crearProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.next();

        System.out.println("Ingrese el precio unitario del producto:");
        double precioUnitario = scanner.nextDouble();

        OrigenFabricacion origenFabricacion = seleccionarOrigen(scanner);
        Categoria categoria = seleccionarCategoria(scanner);

        Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
        productos.add(producto);
        System.out.println("Producto creado correctamente.");
    }

    private static OrigenFabricacion seleccionarOrigen(Scanner scanner) {
        System.out.println("Seleccione el origen de fabricación:");
        mostrarOpcionesOrigenFabricacion();
        int opcionOrigen = scanner.nextInt();
        switch (opcionOrigen) {
            case 1:
                return OrigenFabricacion.ARGENTINA;
            case 2:
                return OrigenFabricacion.CHINA;
            case 3:
                return OrigenFabricacion.BRASIL;
            case 4:
                return OrigenFabricacion.URUGUAY;
            default:
                System.out.println("Opción no válida. Seleccionando Argentina por defecto.");
                return OrigenFabricacion.ARGENTINA;
        }
    }

    private static Categoria seleccionarCategoria(Scanner scanner) {
        System.out.println("Seleccione la categoría del producto:");
        mostrarOpcionesCategoria();
        int opcionCategoria = scanner.nextInt();
        switch (opcionCategoria) {
            case 1:
                return Categoria.TELEFONIA;
            case 2:
                return Categoria.INFORMATICA;
            case 3:
                return Categoria.ELECTROHOGAR;
            case 4:
                return Categoria.HERRAMIENTAS;
            default:
                System.out.println("Opción no válida. Seleccionando Telefonía por defecto.");
                return Categoria.TELEFONIA;
        }
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("Productos registrados:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void modificarProducto(Scanner scanner, ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
            return;
        }

        mostrarProductos(productos);
        System.out.println("Ingrese el código del producto que desea modificar:");
        String codigoModificar = scanner.next();
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigoModificar)) {
                mostrarOpcionesModificacion();
                int opcionModificar = scanner.nextInt();
                switch (opcionModificar) {
                    case 1:
                        modificarDescripcion(scanner, producto);
                        break;
                    case 2:
                        modificarPrecioUnitario(scanner, producto);
                        break;
                    case 3:
                        modificarOrigenFabricacion(scanner, producto);
                        break;
                    case 4:
                        modificarCategoria(scanner, producto);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarOpcionesModificacion() {
        System.out.println("Seleccione qué desea modificar:");
        System.out.println("1 - Descripción");
        System.out.println("2 - Precio Unitario");
        System.out.println("3 - Origen de Fabricación");
        System.out.println("4 - Categoría");
    }

    private static void modificarDescripcion(Scanner scanner, Producto producto) {
        System.out.println("Ingrese la nueva descripción:");
        String nuevaDescripcion = scanner.next();
        producto.setDescripcion(nuevaDescripcion);
        System.out.println("Descripción modificada correctamente.");
    }

    private static void modificarPrecioUnitario(Scanner scanner, Producto producto) {
        System.out.println("Ingrese el nuevo precio unitario:");
        double nuevoPrecio = scanner.nextDouble();
        producto.setPrecioUnitario(nuevoPrecio);
        System.out.println("Precio unitario modificado correctamente.");
    }

    private static void modificarOrigenFabricacion(Scanner scanner, Producto producto) {
        System.out.println("Seleccione el nuevo origen de fabricación:");
        mostrarOpcionesOrigenFabricacion();
        int opcionOrigen = scanner.nextInt();
        producto.setOrigenFabricacion(OrigenFabricacion.values()[opcionOrigen - 1]);
        System.out.println("Origen de fabricación modificado correctamente.");
    }

    private static void modificarCategoria(Scanner scanner, Producto producto) {
        System.out.println("Seleccione la nueva categoría:");
        mostrarOpcionesCategoria();
        int opcionCategoria = scanner.nextInt();
        producto.setCategoria(Categoria.values()[opcionCategoria - 1]);
        System.out.println("Categoría modificada correctamente.");
    }

    private static void mostrarOpcionesOrigenFabricacion() {
        System.out.println("1 - Argentina");
        System.out.println("2 - China");
        System.out.println("3 - Brasil");
        System.out.println("4 - Uruguay");
    }

    private static void mostrarOpcionesCategoria() {
        System.out.println("1 - Telefonía");
        System.out.println("2 - Informática");
        System.out.println("3 - Electro hogar");
        System.out.println("4 - Herramientas");
    }
}

