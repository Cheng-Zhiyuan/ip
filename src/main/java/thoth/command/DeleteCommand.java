package thoth.command;

import thoth.TaskManager;
import thoth.Storage;
import thoth.UserInterface;
import thoth.exceptions.ThothException;

import java.io.IOException;

public class DeleteCommand extends Command {
    int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        if (taskIndex < 0 || taskIndex >= taskManager.getTaskList().size()) {
            throw new ThothException("Task index out of range");
        }
        UserInterface.printDeleteTask(taskManager.getTask(taskIndex), taskManager.getTaskCount() - 1);
        taskManager.removeTask(taskIndex);
        try {
            Storage.saveTasks(taskManager.getTaskList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
