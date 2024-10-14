package exercises.uebung2.view;

import exercises.uebung2.control.ConcreteMember;
import exercises.uebung2.control.Container;

public class Main {
    public static void main(String[] args) {
        Container bmg = new Container();
        ConcreteMember chris = new ConcreteMember(1);
        ConcreteMember max = new ConcreteMember(2);
        ConcreteMember min = new ConcreteMember(3);
        bmg.addMember(chris);
        bmg.addMember(max);
        bmg.addMember(chris);
        bmg.addMember(min);
        System.out.println("size = " + bmg.size());
        System.out.println("Ausgabe einfügen: ");
        bmg.dump();
        System.out.println("\n Ausgabe löschen: ");
        System.out.println(bmg.deleteMember(2));
        bmg.dump();
    }
}
