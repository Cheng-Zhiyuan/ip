package thoth.main;

import thoth.command.Command;
import thoth.logic.TaskManager;
import thoth.parser.Parser;
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
            // extracts out the command from the user input
            Command command = Parser.parse(userInput);
            // Executes the command parsed out
            command.execute(taskManager,ui);

            if(command.isExit()) {
                break;
            }
        }
    }
}
