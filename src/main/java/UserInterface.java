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

    public static void printTask(Task[] task, int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(task[i].toString());
        }
    }
}
