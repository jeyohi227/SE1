package exercises.uebung2.test;

import static org.junit.jupiter.api.Assertions.*;

import exercises.uebung2.control.ConcreteMember;
import exercises.uebung2.control.Container;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContainerTest {

    static Container container;
    static ConcreteMember member1;
    static ConcreteMember member2;
    static ConcreteMember member3;

    @BeforeEach
    void init(){
        container = new Container();
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
        member3 = new ConcreteMember(1);
    }

    @Test
    void testinit() {
        assertEquals(0, container.size());
    }

    @Test
    void testadd() {
        container.addMember(member1);
        assertEquals(1, container.size()); // member1 mit ID 1
        container.addMember(member2);
        assertEquals(2, container.size()); // member2 mit ID 2
        container.addMember(member3);
        assertEquals(2, container.size()); // member3 mit ID 1
    }
    @Test
    void testdelete() {
        container.addMember(member1);
        container.addMember(member2);
        container.deleteMember(2);
        assertEquals(1, container.size());
        container.deleteMember(66); //unzulässige ID
        assertEquals(1, container.size());
        container.deleteMember(1);
        assertEquals(0, container.size());
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class, ()->{container.addMember(null);});
        assertEquals(0, container.size());
        container.addMember(member1);
        assertThrows(NullPointerException.class, ()->{container.deleteMember(null);});
        assertEquals(1, container.size());
    }

}
