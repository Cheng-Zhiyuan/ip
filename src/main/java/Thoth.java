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
                while (true) {
                    try {
                        int taskIndex = Integer.parseInt(userInput.replace("mark", "").trim()) - 1;

                        if (taskIndex < 0 || taskIndex >= taskManager.getTaskCount()) {
                            System.out.println("Task number out of range! Enter a number between 1 and" + taskManager.getTaskCount());
                            userInput = ui.readInput();
                            continue;
                        }

                        taskManager.markTaskAsDone(taskIndex);
                        Task updatedTask = taskManager.getTaskList()[taskIndex];
                        UserInterface.printMarkAsDone(updatedTask);
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number(integer)");
                    }

                    userInput = ui.readInput();
                }

                // unmark tasks
            } else if (userInput.startsWith("unmark")) {
                while(true) {
                    try {
                        int taskIndex = Integer.parseInt(userInput.replace("unmark", "").trim()) - 1;

                        if (taskIndex < 0 || taskIndex >= taskManager.getTaskCount()) {
                            System.out.println("Task number out of range! Enter a number between 1 and" + taskManager.getTaskCount());
                            userInput = ui.readInput();
                            continue;
                        }

                        taskManager.markTaskAsNotDone(taskIndex);
                        Task updatedTask = taskManager.getTaskList()[taskIndex];
                        UserInterface.printMarkAsUndone(updatedTask);
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number(integer)");
                    }
                    userInput = ui.readInput();
                }

                // mark as todo
            } else if (userInput.startsWith("todo")) {
                while (true) {
                    String description = userInput.replace("todo", "").trim();

                    if (description.isEmpty()) {
                        System.out.println("Opps task description is empty");
                        userInput = ui.readInput();
                        continue;
                    }

                    Task newTask = new Todo(description);
                    taskManager.addTask(newTask);
                    UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
                    break;
                }

            } else if (userInput.startsWith("deadline")) {
                while (true) {
                    String[] parts = userInput.replace("deadline", "").trim().split(" /by ");
                    String description = parts[0];
                    String by = (parts.length > 1) ? parts[1] : "No deadline specified";

                    if (description.isEmpty() || by.isEmpty()) {
                        System.out.println("Opps task description is empty");
                        userInput = ui.readInput();
                        continue;
                    }

                    Task newTask = new Deadline(description, by);
                    taskManager.addTask(newTask);
                    UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
                    break;
                }

            } else if (userInput.startsWith("event")) {
                while (true) {
                    String[] parts = userInput.replace("event", "").trim().split(" /from ");
                    String description = parts[0].trim(); // Extracts "meeting"

                    String from = "No end time specified";
                    String to = "No end time specified";

                    if (parts.length > 1) {
                        String[] timeParts = parts[1].split(" /to ");
                        from = timeParts[0].trim(); // Extracts "2pm"
                        if (timeParts.length > 1) {
                            to = timeParts[1].trim(); // Extracts "4pm"
                        }
                    }

                    if (from.isEmpty() || to.isEmpty() || description.isEmpty()) {
                        System.out.println("Opps you input is invalid please check your description or timeframe");
                        userInput = ui.readInput();
                        continue;
                    }
                    Task newTask = new Event(description, from, to);
                    taskManager.addTask(newTask);
                    UserInterface.printAddedTask(newTask, taskManager.getTaskCount());
                    break;
                }
            } else {
                Task newTask = new Task(userInput);
                taskManager.addTask(newTask);
                UserInterface.printMessage(String.format(UserInterface.INDENT + "Added: %s", "", newTask.getDescription()));
            }
        }
    }

}
