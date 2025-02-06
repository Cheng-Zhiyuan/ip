import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
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

    public static void printTask(Task[] task, int taskCount) {
        int listIndex = 1;
        for (int i = 0; i < taskCount; i++) {
            System.out.printf(INDENT + "%d. %s%n", "", listIndex, task[i].getTaskString());
            listIndex++;
        }
    }
}
