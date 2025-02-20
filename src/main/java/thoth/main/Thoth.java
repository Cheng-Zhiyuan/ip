package thoth.main;

import thoth.command.Command;
import thoth.logic.TaskManager;
import thoth.parser.Parser;
import thoth.tasks.Deadline;
import thoth.tasks.Event;
import thoth.tasks.Task;
import thoth.tasks.Todo;
import thoth.ui.UserInterface;

public class Thoth {

    public static void main(String[] args) {
        // Create The task Manager and the User interface
        TaskManager taskManager = new TaskManager();
        UserInterface ui = new UserInterface();

        // Print Greeting.
        ui.printGreetingMessage();

        // String for user input
        String userInput;

        // Create an endless loop for adding list
        while (true) {
            userInput = ui.readInput();
            Command command = Parser.parse(userInput);
            command.execute(taskManager,ui);

            if(command.isExit()) {
                break;
            }
        }
    }

}
