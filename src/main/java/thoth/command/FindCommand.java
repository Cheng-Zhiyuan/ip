package thoth.command;

import thoth.TaskManager;
import thoth.UserInterface;
import thoth.tasks.Task;  // Assuming tasks are represented by a Task class

import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    String keyWord;

    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public void execute(TaskManager taskManager, UserInterface ui) {
        if (keyWord.trim().isEmpty()) {
            UserInterface.printMessage("Keyword cannot be empty. Please enter a valid keyword.");
            return;
        }

        List<Task> matchedTasks = new ArrayList<>();

        // Retrieve the list of tasks from TaskManager
        List<Task> tasks = taskManager.getTaskList();

        // Search for tasks that contain the keyword (case-insensitive)
        for (Task task : tasks) {
            if (task.getTaskString().toLowerCase().contains(keyWord.toLowerCase())) {
                matchedTasks.add(task);
            }
        }

        // Display the matching tasks or an appropriate message if none are found
        if (matchedTasks.isEmpty()) {
            UserInterface.printMessage("No matching tasks found for keyword: " + keyWord);
        } else {
            UserInterface.printMessage("Here are the matching tasks:");
            for (int i = 0; i < matchedTasks.size(); i++) {
                UserInterface.printMessage((i + 1) + ". " + matchedTasks.get(i).getTaskString());
            }
        }
    }
}
