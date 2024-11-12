package exercises.ueb04prototype.model;

import java.io.Serializable;

public class UserStory implements Comparable<UserStory>, Serializable {
    // ToDo: Sind die Attribute der Klasse UserStory vollständig? Wie sieht es mit den
    //  Sichtbarkeiten aus? (F4)
    //-> Sind nur im jeweiligen Package sichtbar
    // Akzeptanzkriterium fehlt

    // Instanzvariablen
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

    // Konstruktoren
    public UserStory(String titel, int aufwand, int id, int mehrwert, int risiko, int strafe, String project) {
        this.id = id;
        this.titel = titel;
        this.aufwand = aufwand;
        this.risiko = risiko;
        this.strafe = strafe;
        this.mehrwert = mehrwert;
        prio = (double) (aufwand + strafe) / (mehrwert + risiko);
        this.project = project;
    }
    public UserStory() {
    }

    // Instanzmethoden
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
    public int getRisiko() {
        return risiko;
    }
    public void setRisiko(int risiko) {
        this.risiko = risiko;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String toString() {
        return "Userstory{" +
                "titel='" + titel + '\'' +
                ", aufwand=" + aufwand +
                ", id=" + id +
                ", mehrwert=" + mehrwert +
                ", risiko=" + risiko +
                ", strafe=" + strafe +
                ", prio=" + prio +
                ", project=" + project + '\'' +
                '}';
    }

    @Override
    public int compareTo(UserStory input) {
        if(input.getPrio() == this.getPrio())
            return 0;
        if(this.getPrio() > input.getPrio())
            return 1;
        else
            return -1;
    }
}
