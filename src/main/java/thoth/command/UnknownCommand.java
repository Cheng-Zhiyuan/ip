package thoth.command;

import thoth.logic.TaskManager;
import thoth.ui.UserInterface;

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
