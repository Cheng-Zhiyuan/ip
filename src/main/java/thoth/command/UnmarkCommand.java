package thoth.command;

import thoth.logic.TaskManager;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

public class UnmarkCommand extends Command{
    int taskIndex;
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        taskManager.markTaskAsNotDone(taskIndex);
        Task updatedTask = taskManager.getTaskList()[taskIndex];
        UserInterface.printMarkAsUndone(updatedTask);
    }
}
