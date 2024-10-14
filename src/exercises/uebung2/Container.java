package exercises.uebung2;
import java.util.ArrayList;

public class Container {

    ArrayList<ConcreteMember> membersClub = new ArrayList<>();
    ArrayList<Integer> membersID = new ArrayList<>();

    private int size = 0;

    public void addMember(ConcreteMember member) {
        /**
         * fügt ein neuen Member in die ArrayList hinzu, wenn er noch nicht enthalten ist
         * -> sonst: wirft die Methode eine ContainerException
         */
        try {
            add(member);
        }
        catch (ContainerException e) {
            System.out.println("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
        }
    }

    private void add(ConcreteMember member) throws ContainerException {
        if(membersID.contains(member.getID())) {
            throw new ContainerException();
        }else{
            membersID.add(member.getID());
            membersClub.add(member);
            size++;
        }
    }
    public void deleteMember(Integer ID) {

        size--;
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
