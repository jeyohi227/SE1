package exercises.ueb4.ueb04prototype.model.util;

import exercises.ueb4.ueb04prototype.model.interfaces.hasID;

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
