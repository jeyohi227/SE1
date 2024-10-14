package exercises.uebung2;

public class MAin {
    public static void main(String[] args) {
        Container bmg = new Container();
        ConcreteMember chris = new ConcreteMember(2);
        ConcreteMember max = new ConcreteMember(2);
        ConcreteMember min = new ConcreteMember(2);
        bmg.addMember(chris);
        bmg.addMember(max);
        bmg.addMember(chris);
        bmg.addMember(min);
        System.out.println(bmg.size());
        bmg.dump();
    }
}
