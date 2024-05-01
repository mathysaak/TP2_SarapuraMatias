package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elija una opcion:");
            mostrarMenu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                sc.nextLine(); 
                opcion = 0; 
            }

            switch(opcion) {
                case 1:
                    crearEfemeride(sc, efemerides);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(sc, efemerides);
                    break;
                case 4:
                    modificarEfemeride(sc, efemerides);
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }

        } while( opcion != 5);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("1 – Crear efeméride\r\n"
                + "2 – Mostrar efemérides\r\n"
                + "3 – Eliminar efeméride\r\n"
                + "4 – Modificar efeméride\r\n"
                + "5 – Salir.");
    }

    private static void crearEfemeride(Scanner sc, ArrayList<Efemeride> efemerides) {
        try {
            System.out.println("Ingrese el mes: [1 a 12]");
            int mesNumero = sc.nextInt();
            sc.nextLine(); 
            if (mesNumero < 1 || mesNumero > 12) {
                throw new Exception("Ingrese un mes válido [1 a 12].");
            }

            Mes mes = Mes.values()[mesNumero - 1];
            
            System.out.println("Ingrese el día:");
            int dia = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Ingrese la descripción de la efeméride:");
            String descripcion = sc.nextLine();

            Efemeride efemeride = new Efemeride(mes, dia, descripcion);
            efemerides.add(efemeride);
            System.out.println("Efeméride creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error: Ingrese un número válido.");
            sc.nextLine();
        }
    }

    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides registradas.");
            return;
        }

        System.out.println("Efemérides registradas:");
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride.getMes()+" Dia: "+efemeride.getDia()+" Efemeride: "+efemeride.getDetalle());
        }
    }

    private static void eliminarEfemeride(Scanner sc, ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para eliminar.");
            return;
        }

        System.out.println("Efemérides registradas:");
        for (int i = 0; i < efemerides.size(); i++) {
            System.out.println((i + 1) + ". " + efemerides.get(i));
        }

        try {
            System.out.print("Ingrese el número de la efeméride que desea eliminar: ");
            int numeroEfemeride = sc.nextInt();
            if (numeroEfemeride < 1 || numeroEfemeride > efemerides.size()) {
                throw new Exception("Ingrese un número válido.");
            }
            efemerides.remove(numeroEfemeride - 1);
            System.out.println("Efeméride eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error: Ingrese un número válido.");
            sc.nextLine(); 
        }
    }

    private static void modificarEfemeride(Scanner sc, ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
            return;
        }

        System.out.println("Efemérides registradas:");
        for (int i = 0; i < efemerides.size(); i++) {
            System.out.println((i + 1) + ". " + efemerides.get(i));
        }

        try {
            System.out.print("Ingrese el número de la efeméride que desea modificar: ");
            int numeroEfemeride = sc.nextInt();
            if (numeroEfemeride < 1 || numeroEfemeride > efemerides.size()) {
                throw new Exception("Ingrese un número válido.");
            }

            sc.nextLine();
            Efemeride efemeride = efemerides.get(numeroEfemeride - 1);

            System.out.print("Ingrese el nuevo mes (1 - 12): ");
            int nuevoMesNumero = sc.nextInt();
            sc.nextLine();
            if (nuevoMesNumero < 1 || nuevoMesNumero > 12) {
                throw new Exception("Ingrese un mes válido (1 - 12).");
            }
            Mes nuevoMes = Mes.values()[nuevoMesNumero - 1]; 
            efemeride.setMes(nuevoMes);

            System.out.print("Ingrese la nueva descripción de la efeméride: ");
            String nuevaDescripcion = sc.nextLine();
            efemeride.setDetalle(nuevaDescripcion);

            System.out.println("Efeméride modificada correctamente.");
        } catch (Exception e) {
            System.out.println("Error: Ingrese un número válido.");
            sc.nextLine(); 
        }
    }
}

