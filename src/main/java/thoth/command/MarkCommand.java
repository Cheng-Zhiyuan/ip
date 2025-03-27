package thoth.command;

import thoth.TaskManager;
import thoth.Storage;
import thoth.exceptions.ThothException;
import thoth.tasks.Task;
import thoth.UserInterface;

import java.io.IOException;

public class MarkCommand extends Command {
    int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        if (taskIndex < 0 || taskIndex >= taskManager.getTaskList().size()) {
            throw new ThothException("Task index out of range");
        }
        taskManager.markTaskAsDone(taskIndex);
        Task updatedTask = taskManager.getTaskList().get(taskIndex);
        UserInterface.printMarkAsDone(updatedTask);
        try {
            Storage.saveTasks(taskManager.getTaskList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
