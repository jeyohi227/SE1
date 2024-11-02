package exercises.uebung3.view;

import exercises.uebung3.control.Container;
import exercises.uebung3.control.persistence.PersistenceException;

public class Client {
    public void startClient() {
        //Abholung der Referenz des Container-Objektes (Singleton!) -> Singleton Pattern
        Container container = Container.getInstance();

        //Hinzufügen von Member-Objekt
        try{
            container.store();
        }catch(PersistenceException e){
            e.printStackTrace();
        }

        //Aktuelle Liste beziehen aus dem Container
    }
}
