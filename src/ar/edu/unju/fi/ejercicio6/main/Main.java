package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {

        FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte) 45, 12f);

        Converter<FelinoDomestico, FelinoSalvaje> converter1 = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        FelinoSalvaje felinoSalvaje = converter1.convert(garfield);

        converter1.mostrarObjeto(felinoSalvaje);

        FelinoSalvaje tanner = new FelinoSalvaje("Tanner", (byte) 20, 186f);

        if (Converter.isNotNull(tanner)) {
            Converter<FelinoSalvaje, FelinoDomestico> converter2 = y -> new FelinoDomestico(y.getNombre(), y.getEdad(), y.getPeso());

            FelinoDomestico felinoDomestico = converter2.convert(tanner);

            converter2.mostrarObjeto(felinoDomestico);
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
    }
}

