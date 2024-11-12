package exercises.uebung4.model.util;

import exercises.uebung4.model.interfaces.hasID;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementiert Methoden, die man immer wieder braucht, (z.B. contains() etc.)
 */
public class UtilListe<T extends hasID> {

    private List<T> liste = new ArrayList<>();

    /*
     * Kontrolliert, ob ein Element bereits in einer Liste enthalten ist
     * @param element
     * @return
     */
    public boolean contains( T element) {
        int ID = element.getID();
        for ( T elements : liste) {
            if ( elements.getID() == ID ) {
                return true;
            }
        }
        return false;
    }

}
