package thoth.command;

import thoth.logic.TaskManager;
import thoth.ui.UserInterface;

public abstract class Command {
    public abstract void execute(TaskManager taskManager, UserInterface ui);

    public boolean isExit() {
        return false;
    }
}
