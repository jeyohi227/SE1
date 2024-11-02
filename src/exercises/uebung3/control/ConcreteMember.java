package exercises.uebung3.control;

import exercises.uebung2.control.interfaces.Member;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
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
