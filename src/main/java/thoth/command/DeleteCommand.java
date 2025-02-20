package thoth.command;

import thoth.logic.TaskManager;
import thoth.ui.UserInterface;

public class DeleteCommand extends Command {
    int taskIndex;
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        UserInterface.printDeleteTask(taskManager.getTask(taskIndex), taskManager.getTaskCount() - 1);
        taskManager.removeTask(taskIndex);
    }
}
