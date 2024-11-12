package exercises.ueb04prototype;

import java.io.Serializable;

public class UserStory implements Serializable {
    // ToDo: Sind die Attribute der Klasse UserStory vollständig? Wie sieht es mit den
    //  Sichtbarkeiten aus? (F4)
    //-> Sind nur im jeweiligen Package sichtbar
    // Akzeptanzkriterium fehlt

    private String titel;
    private int id = 0;
    private double prio = 0.0;
    private String project;
    private String akzeptanzkriterium;
    private int risiko;
    private int strafe;
    private int aufwand;
    private int mehrwert;
    //sollten private sein und die Werte zur berechnung nach gloger der Prorität

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public UserStory(int id, String titel, int aufwand, int strafe, int mehrwert, int risiko) {
        this.id = id;
        this.titel = titel;
        prio = (aufwand + strafe) / (mehrwert + risiko);
    }
    public UserStory() {

    }

    public double getPrio() {
        return prio;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAkzeptanzkriterium() {
        return akzeptanzkriterium;
    }
    public void setAkzeptanzkriterium(String akzeptanzkriterium) {
        this.akzeptanzkriterium = akzeptanzkriterium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
