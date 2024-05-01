package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Jugador> Jugadores = new ArrayList<>();
		Jugador test = new Jugador("","", Posicion.ARQUERO);
		Scanner sc = new Scanner(System.in);
		
		 int numeroEntrada;
		    
		    try {
		        do {
		            System.out.println("Elija un numero.");
		            test.mostrarMenu(); 

		            numeroEntrada = sc.nextInt(); 

		            switch(numeroEntrada) {
		                case 1:
		                    altaJugador(sc, Jugadores);
		                    break;
		                case 2:
		                    mostrarJugadores(Jugadores);
		                    break;
		                case 3:
		                    modificarDatosJugador(sc, Jugadores);
		                    break;
		                case 4:
		                    eliminarJugador(sc, Jugadores);
		                    break;
		                case 5:
		                    System.out.println("Fin del programa");
		                    break;
		                default:
		                    System.out.println("Ingrese un dato correcto");          
		            }
		        } while(numeroEntrada != 5);
		    } catch (Exception e) { 
		        System.out.println("Error, ingrese un número válido.");
		    } finally {
		        sc.close(); 
		    }
		}


	private static void altaJugador(Scanner sc, ArrayList<Jugador> jugadores) {
	    try {
	        System.out.println("Ingrese el nombre del jugador: ");
	        String nombre = sc.nextLine();
	        sc.nextLine();
	        System.out.println("Ingrese el apellido del jugador: ");
	        String apellido = sc.nextLine();
	        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
	        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());
	        System.out.println("Ingrese la nacionalidad del jugador: ");
	        String nacionalidad = sc.nextLine();
	        System.out.println("Ingrese la estatura del jugador en cm: ");
	        int estatura = sc.nextInt();
	        System.out.println("Ingrese el peso del jugador: ");
	        double peso = sc.nextDouble();
	        sc.nextLine();
	        
	        System.out.println("Posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
	        String posicionStr = sc.nextLine();
	        Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());

	        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	        jugadores.add(jugador);
	        System.out.println("Jugador agregado.");
	        
	    } catch (Exception e) {
	        System.out.println("Error, ingrese un dato correcto.");
	    }
	}

	
    private static void eliminarJugador(Scanner sc, ArrayList<Jugador> Jugadores) {
    try {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = sc.nextLine();

        Iterator<Jugador> iterador = Jugadores.iterator();
        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                iterador.remove();
                System.out.println("Jugador eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró al jugador.");
        
    } catch (Exception e) { System.out.println("Error, ingrese dato correcto.");}
    }
    
    private static void mostrarJugadores(ArrayList<Jugador> Jugadores) {
        for (Jugador jugador : Jugadores) {
            System.out.println(jugador);
        }
    }
    
    private static void modificarDatosJugador(Scanner sc, ArrayList<Jugador> jugadores) {
    	try {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del jugador: ");
        String apellido = sc.nextLine();

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {     
                System.out.println("Nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
                String nuevaPosicionStr = sc.nextLine();
                try {
                    Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
                    jugador.setPosicion(nuevaPosicion);
                    System.out.println("Datos del jugador modificados correctamente.");
                    return;
                } catch (Exception e) {
                    System.out.println("Posición inválida. Intente de nuevo.");
                    return;
                }
            }
        }

        System.out.println("No se encontró al jugador.");
        
    } catch (Exception e) { System.out.println("Error, ingrese dato correcto.");}
    }

}
