package exercises.uebung1.factories;


import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;

public class TranslatorFactory {
    /*
     * erzeugt ein Objekt der Klasse control.GermanTranslator
     */


    /*
     * Design Pattern (dt. Entwurfsmuster): Factory Method Pattern ([GoF])
     * Problem: Inkonsistente und verteilte Erzeugung von Objekten
     * Lösung: Factory Klasse zur konsistenten und zentralen Erzeugung von Objekten
     * */
    public static Translator createGermanTranslator() {
        GermanTranslator translator = new GermanTranslator();
        return translator;
    }
}
