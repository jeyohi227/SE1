package exercises.uebung2;

public class ConcreteMember implements Member {
    private Integer ID;
    public ConcreteMember(Integer ID) {
        this.ID = ID;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }
    public String toString() {
        return "Member (ID = " + ID + ")";
    }
}
