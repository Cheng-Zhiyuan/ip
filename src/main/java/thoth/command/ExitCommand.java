package thoth.command;

import thoth.TaskManager;
import thoth.UserInterface;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        ui.printGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
