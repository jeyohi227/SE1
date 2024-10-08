package exercises.uebung1.factories;


import exercises.uebung1.control.*;


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
