package exercises.ueb4.ueb04prototype.model;

import exercises.ueb4.ueb04prototype.model.exception.ContainerException;
import exercises.ueb4.ueb04prototype.model.interfaces.hasID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Klasse zum Management sowie zur Eingabe und Ausgabe von User-Stories.
 * Die Anwendung wird über dies Klasse auch gestartet (main-Methode hier vorhanden)
 *
 * erstellt von Julius P., H-BRS 2024, Version 1.1
 *
 * Strategie für die Wiederverwendung (Reuse):
 * - Anlegen der Klasse UserStory
 * - Anpassen des Generic in der List-Klasse (VORHER: Member, NEU: UserStory)
 * - Anpassen der Methodennamen
 *
 * ToDo: Wie bewerten Sie diese Strategie? Was ist ihre Strategie zur Wiederverwendung? (F1)
 *
 * Entwurfsentscheidung: Die wichtigsten Zuständigkeiten (responsibilities)
 * sind in einer Klasse, d.h. Container?
 * ToDo: Wie bewerten Sie diese Entscheidung? Was wäre ein sinnvolle Aufteilung (F2, F6)
 *
 */

public class Container<T extends hasID> {

    // Interne ArrayList zur Abspeicherung der Objekte vom Type UserStory
    private List<T> liste = null;

    // Statische Klassen-Variable, um die Referenz
    // auf das einzige Container-Objekt abzuspeichern
    // Diese Variante sei thread-safe, so hat Hr. P. es gehört... stimmt das?
    // Todo: Bewertung Thread-Safeness (F1)
    // Todo: Bewertung Speicherbedarf (F1)
    private static Container instance = new Container();

    // URL der Datei, in der die Objekte gespeichert werden
    final static String LOCATION = "allStories.ser";

    /**
     * Liefert ein Singleton zurück.
     * @return
     */
    public static Container getInstance() {
        return instance;
    }

    /**
     * Vorschriftsmäßiges Ueberschreiben des Konstruktors (private) gemaess Singleton-Pattern (oder?)
     * Nun auf private gesetzt! Vorher ohne Access Qualifier (--> dann package-private)
     */
    private Container(){
        liste = new ArrayList<>();
    }

    /*
     * Methode zum Speichern der Liste. Es wird die komplette Liste
     * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
     */
    public void store() throws ContainerException {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( Container.LOCATION );
            oos = new ObjectOutputStream(fos);

            oos.writeObject( this.liste );
            System.out.println( this.size() + " UserStory wurden erfolgreich gespeichert!");
        }
        catch (IOException e) {
            e.printStackTrace();
            //  Delegation in den aufrufendem Context
            // (Anwendung Pattern "Chain Of Responsibility)
            throw new ContainerException("Fehler beim Abspeichern");
        }
    }

    /*
     * Methode zum Laden der Liste. Es wird die komplette Liste
     * inklusive ihrer gespeicherten UserStory-Objekte geladen.
     */
    public void load() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( Container.LOCATION );
            ois = new ObjectInputStream(fis);

            // Auslesen der Liste
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                this.liste = (List) obj;
            }
            System.out.println("Es wurden " + this.size() + " UserStory erfolgreich reingeladen!");
        }
        catch (IOException e) {
            System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
    }

    /**
     * Methode zum Hinzufügen eines Mitarbeiters unter Wahrung der Schlüsseleigenschaft
     * @param
     * @throws ContainerException
     */
    public void addUserStory ( T element ) throws ContainerException {
        if ( liste.contains(element) == true ) {
            ContainerException ex = new ContainerException("ID bereits vorhanden!");
            throw ex;
        }
        liste.add(element);
    }



    /**
     * Ermittlung der Anzahl von internen UserStory
     * -Objekten
     * @return
     */
    public int size() {
        return liste.size();
    }

    /**
     * Methode zur Rückgabe der aktuellen Liste mit Stories
     * Findet aktuell keine Anwendung bei Hr. P.
     * @return
     */
    public List<T> getCurrentList() {
        return this.liste;
    }

    /**
     * Liefert eine bestimmte UserStory zurück
     * @param id
     * @return
     */
    /*
    private UserStory getUserStory(int id) {
        for ( T userStory : liste) {
            if (id == userStory.getID() ){
                return userStory;
            }
        }
        return null;
    }

     */

}
