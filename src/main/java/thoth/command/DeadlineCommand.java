package thoth.command;

import thoth.logic.TaskManager;
import thoth.tasks.Deadline;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

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
        UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
    }
}
