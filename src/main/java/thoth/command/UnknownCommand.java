package thoth.command;

import thoth.TaskManager;
import thoth.UserInterface;

public class UnknownCommand extends Command {
    String message;

    public UnknownCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        UserInterface.printMessage(message);
    }
}
