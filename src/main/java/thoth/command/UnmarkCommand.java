package thoth.command;

import thoth.logic.TaskManager;
import thoth.storage.Storage;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

import java.io.IOException;

public class UnmarkCommand extends Command {
    int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
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
