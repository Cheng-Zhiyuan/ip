package thoth.command;

import thoth.TaskManager;
import thoth.Storage;
import thoth.tasks.Task;
import thoth.tasks.Todo;
import thoth.UserInterface;

import java.io.IOException;

public class TodoCommand extends Command {
    String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        Task newTask = new Todo(description);
        taskManager.addTask(newTask);
        try {
            Storage.writeFile(newTask.getTaskString());
        } catch (IOException e) {
            UserInterface.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
    }
}
