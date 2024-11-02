package exercises.uebung3.control.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    private ObjectOutputStream oos = null;
    private FileOutputStream fos = null;

    private FileInputStream fis = null;
    private ObjectInputStream ois = null;

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help! Good source:
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 15th 2024)
     */
    public void save(List<E> member) throws PersistenceException {
        try {
            fos = new FileOutputStream(location);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(member);
            System.out.println("LOG: Es wurden " + member.size() + " Member-Objekte wurden erfolgreich gespeichert!");

            oos.close();
            fos.close();
        }catch(IOException e){
            /*
             * Könnte man ausgeben für interne Debugs: e.printStackTrace();
             * Chain of Responsibility: Hochtragen der Exception in Richtung Ausgabe (UI)
             * Übergabe in ein lesbares Format für den Benutzer
             */
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ExceptionType.SaveFailure,
                    "Fehler beim Speichern der Datei!");
        }

    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        try {
            fis = new FileInputStream(location);
        } catch (FileNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable
                    , "Error in opening the connection, File could not be found!");
        }
        try {
            ois = new ObjectInputStream(fis);
        } catch(IOException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable
                    , "Error in opening the connection, problems with the stream");
        }

        // Load the Objects from stream
        List<E> member = null;

        try {
            // Auslesen der Liste
            Object obj = ois.readObject();
            if(obj instanceof List<?>){
                member = (List) obj;
            }
            System.out.println("LOG: Es wurden " + member.size() + " User Stories erfolgreich reingeladen!");
            return member;
        }catch (IOException e) {
            //Sup-Optimal, da Exception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure
            , "Fehler beim Laden der Datei!");
        }catch(ClassNotFoundException e){
            //chain of Responsibility erfuellt, durch Throw der Exception
            // kann UI benauchritigt werden!
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure
            , "Fehler beim Laden der Datei! Class not found!");
        }
    }
}