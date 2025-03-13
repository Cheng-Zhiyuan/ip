package thoth.command;

import thoth.logic.TaskManager;
import thoth.storage.Storage;
import thoth.tasks.Deadline;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

import java.io.IOException;

public class DeadlineCommand extends Command {
    String description;
    String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        Task newTask = new Deadline(description, by);
        taskManager.addTask(newTask);
        try {
            Storage.writeFile(newTask.getTaskString());
        } catch (IOException e) {
            UserInterface.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
    }
}
