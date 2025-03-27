package thoth.command;

import thoth.TaskManager;
import thoth.UserInterface;

public abstract class Command {
    public abstract void execute(TaskManager taskManager, UserInterface ui);

    public boolean isExit() {
        return false;
    }
}
