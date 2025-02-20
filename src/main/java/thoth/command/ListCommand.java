package thoth.command;

import thoth.logic.TaskManager;
import thoth.ui.UserInterface;

public class ListCommand extends Command {

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        UserInterface.printTask(taskManager.getTaskList(), taskManager.getTaskCount());
    }
}
