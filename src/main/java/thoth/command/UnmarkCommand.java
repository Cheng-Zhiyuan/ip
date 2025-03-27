package thoth.command;

import thoth.TaskManager;
import thoth.Storage;
import thoth.exceptions.ThothException;
import thoth.tasks.Task;
import thoth.UserInterface;

import java.io.IOException;

public class UnmarkCommand extends Command {
    int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        if (taskIndex < 0 || taskIndex >= taskManager.getTaskList().size()) {
            throw new ThothException("Task index out of range");
        }

        taskManager.markTaskAsNotDone(taskIndex);
        Task updatedTask = taskManager.getTaskList().get(taskIndex);
        UserInterface.printMarkAsUndone(updatedTask);
        try {
            Storage.saveTasks(taskManager.getTaskList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
