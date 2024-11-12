package exercises.uebung4.view;

import exercises.uebung4.control.Container;
import exercises.uebung4.control.persistence.PersistenceException;

public class UserStoryView {
    Container container = Container.getInstance();

    // Eingabe einer USer Story
    public static void enter() {}
    // persistentes Abspeichern von User Stories -> PersistenceStrategyStream
    public static void store() {}
    // laden von User Stories
    public void load() {}
    // Ausgabe aller eingegebenen User Stories -> sortiert nach berechneten Priorisierung
    public static void dump() {}
    // Verlassen der Anwendung
    public static void exit() {}
    // Anzeige aller möglichen Befehle
    public static void help() {}

}
