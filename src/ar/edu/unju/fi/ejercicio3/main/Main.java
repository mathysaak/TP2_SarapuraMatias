package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		
		for(Provincia province: provincias) {
			System.out.println("Nombre: "+province);
			System.out.println("Poblacion: "+ province.getPoblacion()+" Superficie: "+province.getSuperficie()+"km2");
			System.out.println("Densidad poblacional: "+ province.densidadPoblacion());
		}

	}
	}


