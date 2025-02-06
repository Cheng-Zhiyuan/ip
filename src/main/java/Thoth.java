
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
            // exit condition
            if (userInput.equals("bye")) {
                ui.printGoodbye();
                break;

                // list tasks
            } else if (userInput.equals("list")) {
                UserInterface.printTask(taskManager.getTaskList(), taskManager.getTaskCount());

                // mark tasks
            } else if (userInput.startsWith("mark")) {
                int taskIndex = Integer.parseInt(userInput.replace("mark", "").trim()) - 1;
                taskManager.markTaskAsDone(taskIndex);
                Task updatedTask = taskManager.getTaskList()[taskIndex];
                UserInterface.printMarkAsDone(updatedTask);

                // unmark tasks
            } else if (userInput.startsWith("unmark")) {
                int taskIndex = Integer.parseInt(userInput.replace("unmark", "").trim()) - 1;
                taskManager.markTaskAsNotDone(taskIndex);
                Task updatedTask = taskManager.getTaskList()[taskIndex];
                UserInterface.printMarkAsUndone(updatedTask);

                // add tasks
            } else {
                Task newTask = new Task(userInput);
                taskManager.addTask(newTask);
                UserInterface.printMessage(String.format(UserInterface.INDENT + "Added: %s", "", newTask.getDescription()));
            }
        }
    }

}
