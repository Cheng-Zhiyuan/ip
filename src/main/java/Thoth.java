import java.util.Scanner;

public class Thoth {
    public static final int MAX_TASKS = 100;
    public static final String INDENT = "%4s";
    public static final String EMPTY_BOX = "[ ]";
    public static final String MARKED_BOX = "[X]";

    public static void main(String[] args) {
        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");

        String[] taskList = new String[MAX_TASKS];
        String userInput;

        int listNumber = 1;

        // Create an endless loop for adding list
        while (true) {
            userInput = new Scanner(System.in).nextLine();
            // condition for the user to exit the program
            if (userInput.equals("bye")) {
                System.out.printf(INDENT + "Bye. Hope to see you again soon!", "");
                break;

            } else if (userInput.equals("list")) {
                for (int i = 0; i < listNumber; i++) {
                    if (taskList[i] != null) {
                        System.out.printf(INDENT + "%d.%s%n", "", i + 1, taskList[i]);
                    }
                }

            } else if (userInput.startsWith("mark")) {
                String userInputNumber = userInput.replace("mark", "").trim();
                int index = Integer.parseInt(userInputNumber) - 1;
                taskList[index] = taskList[index].replace(EMPTY_BOX, MARKED_BOX);
                System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
                System.out.printf(INDENT + "%s%n", "", taskList[index]);

            } else if (userInput.startsWith("unmark")) {
                String userInputNumber = userInput.replace("unmark", "").trim();
                int index = Integer.parseInt(userInputNumber) - 1;
                taskList[index] = taskList[index].replace(MARKED_BOX, EMPTY_BOX);
                System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
                System.out.printf(INDENT + "%s%n", "", taskList[index]);

            } else {
                taskList[listNumber - 1] = EMPTY_BOX + " " + userInput;
                System.out.printf(INDENT + "Added: %s%n", "", userInput);

                listNumber++;
            }
        }
    }
}
