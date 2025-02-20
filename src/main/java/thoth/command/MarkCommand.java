package thoth.command;

import thoth.logic.TaskManager;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

public class MarkCommand extends Command{
    int taskIndex;
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        taskManager.markTaskAsDone(taskIndex);
        Task updatedTask = taskManager.getTaskList().get(taskIndex);
        UserInterface.printMarkAsUndone(updatedTask);
    }
}
