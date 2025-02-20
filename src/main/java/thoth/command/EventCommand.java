package thoth.command;

import thoth.logic.TaskManager;
import thoth.storage.Storage;
import thoth.tasks.Event;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

import java.io.IOException;

public class EventCommand extends Command {
    String description;
    String from;
    String to;
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        Task newTask = new Event(description, from, to);
        taskManager.addTask(newTask);
        try {
            Storage.writeFile(newTask.getTaskString());
        } catch (IOException e) {
            UserInterface.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
    }
}
