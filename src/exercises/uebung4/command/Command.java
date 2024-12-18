package exercises.uebung4.command;

public interface Command {
    // führt den Befehl aus
    void execute();
    // macht den zuletzt ausgeführten Befehl rückgängig
    void undo();
}
