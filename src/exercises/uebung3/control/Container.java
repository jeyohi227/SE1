package exercises.uebung3.control;

import exercises.uebung2.control.ConcreteMember;
import exercises.uebung2.control.Exception.ContainerException;
import exercises.uebung3.control.persistence.PersistenceException;
import exercises.uebung3.control.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;


public class Container {

    private static Container container;

    // Reference to the internal strategy (e.g. MongoDB or Stream)
    private PersistenceStrategy strategy = null;

    private List membersClub = new ArrayList<ConcreteMember>();
    /**
     * Hilfsliste: speichert die ID der Members im membersClub ab
     * Wieso? -> Liste mit allen Primary Keys:
     * Entscheidend für Methoden addMember() und deleteMember()
     */
    private ArrayList<Integer> membersID = new ArrayList<>();

    private int size = 0; //Größe der Liste membersClub

    private Container() {
    }

    public static Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addMember(ConcreteMember member) {
        /**
         * fängt die ContainerException auf und behandelt sie
         */
        if(member == null)
            throw new NullPointerException("übergebender Member is null");

        try {
            add(member);
        }
        catch (ContainerException e) {
            System.out.println("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
        }
    }

    private void add(ConcreteMember member) throws ContainerException {
        /**
         * fügt ein neuen Member in die ArrayList hinzu, wenn er noch nicht enthalten ist
         * -> sonst: wirft die Methode eine ContainerException -> addMember()
         */
        if(membersID.contains(member.getID())) {
            throw new ContainerException();
        }else{
            membersID.add(member.getID());
            membersClub.add(member);
            size++;
        }
    }

    public String deleteMember(Integer ID) {
        /**
         * Aufgabe: entfernt einen Member
         */
        if(ID == null)
            throw new NullPointerException("übergebende ID is null");

        if(membersID.contains(ID)) {
            Object member = membersClub.get(membersID.indexOf(ID));
            membersClub.remove(member);
            membersID.remove(ID);
            size--;
            return "Das Memnber-Objekt mit der ID [" + ID + "] wurde erfolgreich entfernt!";
        }
        return "ungültige übergebende ID";
        /**
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

    // Method for loading Objects. Uses the internally stored strategy object
    // @throws PersistenceException
    public void load() throws PersistenceException {
        if(this.strategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet
            , "Strategy not initialized");
        }

        try {
            List<Member> liste = this.strategy.load();
            this.membersClub = liste;
        } catch(java.lang.UnsupportedOperationException e) {
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
            this.strategy.save(this.membersClub);
        } catch(java.lang.UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable
            , "MongoDB is not implemented!");
        }
    }

    /**
     * Methode zum Löschen aller Member-Ojekte
     * @throws PersistenceException
     */
    public void deleteAllMembers() throws PersistenceException {
        this.membersClub.clear();
    }
}
