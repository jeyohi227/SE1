package exercises.uebung4.control;

import java.io.Serializable;

public class UserStory implements Serializable {
    private int id;
    private String title;
    private String akzeptanzkriterium;
    private int priorisierungswert;



    public UserStory(int id) {
        this.id = id;
        setPriorisierungswert();
    }

    public int id() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String title() {
        return title;
    }
    public void setAkzeptanzkriterium(String akzeptanzkriterium) {
        this.akzeptanzkriterium = akzeptanzkriterium;
    }
    public String Akzeptanzkriterium() {
        return akzeptanzkriterium;
    }
    public int Priorisierungswert() {
        return priorisierungswert;
    }
    private void setPriorisierungswert() {
        // berechnet den Priorisierungswert der US (Gloger)

    }
    public String toString() {
        String s = "";
        s += "|\t" + id + "\t|\t" + title + "\t|\t" + akzeptanzkriterium + "\t|\t" + priorisierungswert + "\t|";
        return s;
    }
}
