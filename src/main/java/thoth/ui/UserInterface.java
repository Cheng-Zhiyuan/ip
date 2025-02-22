package thoth.ui;

import thoth.tasks.Task;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    public static final String INDENT = "%4s";

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void printGreetingMessage() {
        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printMarkAsDone(Task task) {
        System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
    }

    public static void printMarkAsUndone(Task task) {
        System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
    }

    public static void printTask(List<Task> task, int taskCount) {
        int listIndex = 1;
        for (int i = 0; i < taskCount; i++) {
            System.out.printf(INDENT + "%d. %s%n", "", listIndex, task.get(i).getTaskString());
            listIndex++;
        }
    }

    public static void printAddedTask(Task task, int taskCount) {
        System.out.printf(INDENT + "Got it. I've added this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.getTaskString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

    public static void printDeleteTask(List<Task> task, int taskCount) {
        System.out.printf(INDENT + "Noted. I've removed this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.get(0).getTaskString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

}
