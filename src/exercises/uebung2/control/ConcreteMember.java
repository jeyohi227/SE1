package exercises.uebung2.control;

import exercises.uebung2.control.interfaces.Member;

public class ConcreteMember implements Member {
    private Integer ID;
    public ConcreteMember(Integer ID) {
        this.ID = ID;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }
    @Override
    public String toString() {
        return "Member (ID = " + ID + ")";
    }
}
