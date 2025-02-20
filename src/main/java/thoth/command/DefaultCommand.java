package thoth.command;

import thoth.logic.TaskManager;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

public class DefaultCommand extends Command {
    String userInput;
    public DefaultCommand(String userInput) {
        this.userInput = userInput;
    }
    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        Task newTask = new Task(userInput);
        taskManager.addTask(newTask);
        UserInterface.printMessage(String.format(UserInterface.INDENT + "Added: %s", "", newTask.getDescription()));
    }
}
