package exercises.uebung4.controller;


import exercises.uebung4.model.Container;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        InputDialog dialog = new InputDialog();
        dialog.startEingabe();
    }
}
