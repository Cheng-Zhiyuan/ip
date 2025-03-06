package thoth.command;

import thoth.logic.TaskManager;
import thoth.storage.Storage;
import thoth.ui.UserInterface;

import java.io.IOException;

public class DeleteCommand extends Command {
    int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        UserInterface.printDeleteTask(taskManager.getTask(taskIndex), taskManager.getTaskCount() - 1);
        taskManager.removeTask(taskIndex);
        try {
            Storage.saveTasks(taskManager.getTaskList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
