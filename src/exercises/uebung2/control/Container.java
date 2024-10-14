package exercises.uebung2.control;
import exercises.uebung2.control.Exception.ContainerException;

import java.util.ArrayList;

public class Container {

   private ArrayList<ConcreteMember> membersClub = new ArrayList<>();
    /**
     * Hilfsliste: speichert die ID der Members im membersClub ab
     * Wieso? -> Liste mit allen Primary Keys:
     * Entscheidend für Methoden addMember() und deleteMember()
     */
    private ArrayList<Integer> membersID = new ArrayList<>();

    private int size = 0; //Größe der Liste membersClub

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
            ConcreteMember member = membersClub.get(membersID.indexOf(ID));
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
    public void dump() {
        for(ConcreteMember member : membersClub) {
            System.out.println(member);
        }
    }
    public int size() {
        return size;
    }






}
