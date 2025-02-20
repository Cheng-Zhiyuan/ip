package thoth.command;

import thoth.logic.TaskManager;
import thoth.tasks.Task;
import thoth.tasks.Todo;
import thoth.ui.UserInterface;

public class TodoCommand extends Command{
    String description;
    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        Task newTask = new Todo(description);
        taskManager.addTask(newTask);
        UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
    }
}
