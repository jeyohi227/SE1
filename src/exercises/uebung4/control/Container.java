package exercises.uebung4.control;


import exercises.uebung2.control.Exception.ContainerException;
import exercises.uebung3.control.persistence.PersistenceException;
import exercises.uebung3.control.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;


public class Container<T> {

    private static Container container;

    // Reference to the internal strategy (e.g. MongoDB or Stream)
    private PersistenceStrategy strategy = null;

    private List liste = new ArrayList<T>();

    private int size = 0; //Größe der Liste

    private Container() {
    }

    public static synchronized Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addElement(T element) {
        /**
         * fängt die ContainerException auf und behandelt sie
         */
        if(element == null)
            throw new NullPointerException("übergebendes Objekt ist null");

        try {
            add(element);
        }
        catch (ContainerException e) {
            System.out.println("Das Objekt ist bereits vorhanden!");
        }
    }

        private void add(T element) throws ContainerException {
        /**
         * fügt ein neuen Member in die ArrayList hinzu, wenn er noch nicht enthalten ist
         * -> sonst: wirft die Methode eine ContainerException -> addMember()
         */
        if(contains(element)) {
            throw new ContainerException();
        }else{
            liste.add(element);
            size++;
        }
    }

        private boolean contains(T element) {
        for(Object elem : liste){
            if(element.equals(elem)){
                return true;
            }
        }
        return false;
    }

    public void deleteElement(T element) {
        /*
         * Aufgabe: entfernt Objekt mit der übergebenden ID
         */
        if(element == null)
            throw new NullPointerException("übergebende ID is null");

        if(contains(element)) {
            liste.remove(element);
            size--;
            System.out.println("Das Objekt wurde erfolgreich entfernt!");
        }
        System.out.println("ungültige übergebende ID");
        /*
         * Welche Nachteile ergeben sich aus ihrer Sicht für ein solchen Fehlerhandling
         * gegenüber einer Lösung mit Exceptions?
         * Statement: ungewisse Fehlermeldung
         *         -> Man sieht nicht an der Rückgabe des Strings, welcher Fehler jetzt aufgetreten ist.
         *         -> die ID könnte sich nicht im Container befinden,
         *         -> oder ein generell ungültiger Wert könnte übergeben worden sein z.B null
         */
    }

    public int size() {
        return size;
    }

    /**
     * Method for loading Objects. Uses the internally stored strategy object
     * @throws PersistenceException
     */
    public void load() throws PersistenceException {
        if(this.strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet
            , "Strategy not initialized");
        }

        try {
            List<T> liste = this.strategy.load();
            this.liste = liste;
        } catch(UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable
            ,"MongoDB is not implemented!");
        }
    }

    public void setPersistenceStrategy(PersistenceStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Method for storing objects, Uses gne internally stored strategy object
     * @throws PersistenceException
     */
    public void store() throws PersistenceException {
        //speichert Member in der membersclub ab
        if(this.strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet
            , "Strategy not initialized");
        }

        try {
            this.strategy.save(this.liste);
        } catch(UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable
            , "MongoDB is not implemented!");
        }
    }

    /**
     * Methode zum Löschen aller Member-Ojekte
     * @throws PersistenceException
     */
    public void deleteAllMembers() throws PersistenceException {
        this.liste.clear();
    }
}
