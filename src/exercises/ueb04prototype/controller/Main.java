package exercises.ueb04prototype.controller;


import exercises.ueb04prototype.model.Container;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        InputDialog dialog = new InputDialog();
        dialog.startEingabe();
    }
}
