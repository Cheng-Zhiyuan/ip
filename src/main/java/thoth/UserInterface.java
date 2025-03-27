package thoth;

import thoth.tasks.Task;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static final String INDENT = "%4s";
    private final Scanner scanner;

    /**
     * Constructs a new UserInterface and initializes the input scanner.
     */
    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints the specified message to the console.
     *
     * @param message the message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a message indicating that a task has been marked as done.
     *
     * @param task the task that has been marked as done.
     */
    public static void printMarkAsDone(Task task) {
        System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
    }

    /**
     * Prints a message indicating that a task has been marked as not done.
     *
     * @param task the task that has been marked as not done.
     */
    public static void printMarkAsUndone(Task task) {
        System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
    }

    /**
     * Prints the list of tasks to the console.
     *
     * @param task      the list of tasks to be printed.
     * @param taskCount the number of tasks to print.
     */
    public static void printTask(List<Task> task, int taskCount) {
        int listIndex = 1;
        for (int i = 0; i < taskCount; i++) {
            System.out.printf(INDENT + "%d. %s%n", "", listIndex, task.get(i).getTaskString());
            listIndex++;
        }
    }

    /**
     * Prints a message indicating that a task has been added.
     *
     * @param task      the task that has been added.
     * @param taskCount the total number of tasks after the addition.
     */
    public static void printAddedTask(Task task, int taskCount) {
        System.out.printf(INDENT + "Got it. I've added this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

    /**
     * Prints a message indicating that a task has been deleted.
     *
     * @param task      the list of tasks from which the deleted task is assumed to be the first element.
     * @param taskCount the total number of tasks remaining after deletion.
     */
    public static void printDeleteTask(List<Task> task, int taskCount) {
        System.out.printf(INDENT + "Noted. I've removed this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.get(0).getTaskString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

    /**
     * Reads a line of input from the user.
     *
     * @return the input string entered by the user.
     */
    public String readInput() {
        return scanner.nextLine();
    }

    /**
     * Prints the greeting message to the console.
     */
    public void printGreetingMessage() {
        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");
    }

    /**
     * Prints a goodbye message to the console.
     */
    public void printGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the error message to the console.
     *
     * @param message the error message to be printed.
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
