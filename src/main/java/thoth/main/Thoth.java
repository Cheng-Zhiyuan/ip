package thoth.main;

import thoth.command.Command;
import thoth.logic.TaskManager;
import thoth.parser.Parser;
import thoth.storage.Storage;
import thoth.tasks.Task;
import thoth.ui.UserInterface;

import java.io.IOException;
import java.util.List;

public class Thoth {

    public static void main(String[] args) {
        // Create The task Manager and the User interface
        TaskManager taskManager = new TaskManager();
        UserInterface ui = new UserInterface();

        // Print Greeting.
        ui.printGreetingMessage();

        // String for user input
        String userInput;

        try {
            Storage.createFile();
            List<Task> loadedTasks = Storage.loadTasks();
            // Put those tasks into the TaskManager
            for (Task t : loadedTasks) {
                taskManager.addTask(t);
            }
        } catch (IOException e) {
            System.err.println("Could not load tasks: " + e.getMessage());
        }


        // Create an endless loop for adding list
        while (true) {

            userInput = ui.readInput();
            // extracts out the command from the user input
            Command command = Parser.parse(userInput);
            // Executes the command parsed out
            command.execute(taskManager, ui);

            if (command.isExit()) {
                break;
            }
        }
    }
}
