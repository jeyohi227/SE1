package exercises.uebung4.view;


import exercises.uebung4.model.UserStory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserstoryView {
    public void startAusgabe(List<UserStory> liste, String suchParameter) {

        // Es gibt noch einen Compile-Error, den Hr. P nicht versteht
        // Die Ausgabe funktioniert noch nicht so recht

        Collections.sort(liste);

        List<UserStory> reduzierteListe = liste.stream()
                        .filter( userStory -> userStory.getProject().equals(suchParameter))
                        //.filter( userstory -> userstory.getPrio() >= 3)
                        .collect(Collectors.toList());

        for(UserStory userStory : reduzierteListe) {
            System.out.println(userStory.toString());
        }
    }
}
