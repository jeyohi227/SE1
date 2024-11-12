package exercises.uebung4.controller;


import exercises.uebung4.model.Container;
import exercises.uebung4.model.exception.ContainerException;
import exercises.uebung4.model.UserStory;
import exercises.uebung4.view.UserstoryView;

import java.util.Scanner;

public class InputDialog {

    private Container container = Container.getInstance();

    public InputDialog() {

    }
    /*
     * Diese Methode realisiert eine Eingabe über einen Scanner
     * Alle Exceptions werden an den aufrufenden Kontext (hier: main) weitergegeben (throws)
     * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
     */
    public void startEingabe() {
        String strInput = null;

        //Initialisierung des Eingabe-View
        Scanner scanner = new Scanner(System.in);

        // Ausgabe eines Textes zur Begrüßung
        System.out.println("UserStory-Tool v1.1 by Jem H. (dedicated to all my friends from SE-1)");

        while(true) {
            System.out.print("> ");
            strInput = scanner.nextLine();

            //Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            //Falls 'help' eingegeben wurde, werdene alle Befehle ausgedruckt
            if(strings[0].equals("help")){
                System.out.println("Folgende Befehle stehen zur Verfügung:\n" +
                                    "enter\t-\tEingabe einer Userstory\n" +
                                    "store\t-\tAbspeichern von Userstories\n" +
                                    "load\t-\tLaden von Userstories\n" +
                                    "dump\t-\tAusgabe aller Elemente\n" +
                                    "exit\t-\tVerlassen der Anwendung\n" +
                                    "help\t-\tAnzeige aller möglichen Befehle"
                );
            }
            //Auswahl der bisher implementierten Befehle:
            String suchParameter = null;
            if(strings[0].equals("dump")){

                try{
                    suchParameter = strings[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Projekt fehlt");
                }

                UserstoryView view = new UserstoryView();
                view.startAusgabe(this.container.getCurrentList(), suchParameter);
            }
            // Auswahl der bisher implementierten Befehle:
            if(strings[0].equals("enter")){

                System.out.println("Eingabe der Parameter zum Hinzufügen einer Userstory");
                while(true) {
                    // Titel der Userstory festlegen
                    System.out.print("Titel-> ");
                    String titel = scanner.nextLine();
                    //userstory.setTitel(titel);
                    // Aufwand der Userstory festlegen
                    System.out.print("Aufwand-> ");
                    int aufwand = scanner.nextInt();
                    scanner.nextLine();
                    //userstory.setAufwand(aufwand);
                    // ID der Userstory festlegen
                    System.out.print("ID-> ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    //userstory.setId(id);
                    // Mehrwert der Userstory festlegen
                    System.out.print("Mehrwert-> ");
                    int mehrwert = scanner.nextInt();
                    scanner.nextLine();
                    //userstory.setMehrwert(mehrwert);
                    // Risiko der Userstory festlegen
                    System.out.print("Risiko-> ");
                    int risiko = scanner.nextInt();
                    scanner.nextLine();
                    //userstory.setRisiko(risiko);
                    // Strafe der Userstory festlegen
                    System.out.print("Strafe-> ");
                    int strafe = scanner.nextInt();
                    scanner.nextLine();
                    //userstory.setStrafe(strafe);
                    // Projekt der Userstory festlegen
                    System.out.print("Project-> ");
                    String project = scanner.nextLine();
                    //userstory.setProject(project);

                    UserStory userstory = new UserStory(titel, aufwand, id, strafe, mehrwert, risiko, project);
                    try {
                        container.addUserStory(userstory);
                        System.out.println("Userstory wurde erfolgreich abgespeichert");
                    }catch (ContainerException e) {
                        System.out.println("Userstory konnte nicht abgespeichert werden. ID bereits vorhanden!");
                    }
                    break;
                }
            }
            if(strings[0].equals("store")){
                try {
                    container.store();
                } catch(ContainerException e) {
                    System.out.println("Fehler beim Abspeichern (InputDialog)");
                }
            }
            if(strings[0].equals("load")){
                container.load();
            }
            if(strings[0].equals("exit")){
                System.out.println("Anwendung wurde verlassen");
                break;
            }
        }
        scanner.close();
    }
}
