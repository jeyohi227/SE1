package exercises.uebung4.command;

import java.util.HashMap;
import java.util.Stack;

public class CommandHandler {
    public void startEingabe() {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("dump", new DumpCommand());
        commands.put("store", new StoreCommand());
        commands.put("enter", new EnterCommand());

        Command command = commands.get("help");
        command.execute();

        // Historie
        Stack<Command> history = new Stack<>();
        history.push(command);

        history.pop().undo();



    }
}
