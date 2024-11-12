package exercises.uebung4;

import exercises.uebung4.control.UserStory;

public class Main {
    public static void main(String[] args) {
        UserStory us1 = new UserStory(1);
        UserStory us2 = new UserStory(2);
        UserStory us3 = new UserStory(3);

        us1.setTitle("Gebrauch User Story");
        us1.setAkzeptanzkriterium("Hallo ich bin UserStory 1 und beschäftige mich mit Gebrauch");
        System.out.println("|\tid\t|\t\t title \t\t\t| \t\t\t\t\t akzeptanzkriterium \t\t\t\t\t\t |\tpriowert\t|");
        System.out.println(us1.toString());
    }
}
