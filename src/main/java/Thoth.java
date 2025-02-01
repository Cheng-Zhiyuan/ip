import java.util.Scanner;

public class Thoth {
    // parameter for task array initialisation
    public static final int MAX_TASKS = 100;
    // parameter for output indentation
    public static final String INDENT = "%4s";

    public static void main(String[] args) {
        printGreetingMessage();
        Task[] taskList = new Task[MAX_TASKS];
        String userInput;
        int taskCount = 1;

        // Create an endless loop for adding list
        while (true) {
            userInput = new Scanner(System.in).nextLine();
            // exit condition
            if (userInput.equals("bye")) {
                System.out.printf(INDENT + "Bye. Hope to see you again soon!", "");
                break;

                // list tasks
            } else if (userInput.equals("list")) {
                for (int i = 0; i < taskCount; i++) {
                    if (taskList[i] != null) {
                        System.out.printf(INDENT + "%d.%s%n", "", i + 1, taskList[i].getTaskString());
                    }
                }

                // mark tasks
            } else if (userInput.startsWith("mark")) {
                String userInputNumber = userInput.replace("mark", "").trim();
                int index = Integer.parseInt(userInputNumber) - 1;
                taskList[index].markAsDone();
                System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
                System.out.printf(INDENT + "%s%n", "", taskList[index].getTaskString());

                // unmark tasks
            } else if (userInput.startsWith("unmark")) {
                String userInputNumber = userInput.replace("unmark", "").trim();
                int index = Integer.parseInt(userInputNumber) - 1;
                taskList[index].markAsNotDone();
                System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
                System.out.printf(INDENT + "%s%n", "", taskList[index].getTaskString());

                // add tasks
            } else {
                taskList[taskCount - 1] = new Task(userInput);
                System.out.printf(INDENT + "Added: %s%n", "", userInput);
                taskCount++;
            }
        }
    }

    private static void printGreetingMessage() {
        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");
    }
}
