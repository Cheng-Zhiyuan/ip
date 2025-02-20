package thoth.command;

import thoth.logic.TaskManager;
import thoth.ui.UserInterface;

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
