import java.util.Scanner;

public class Thoth {
    public static final int MAX_TASKS = 100;
    public static final String INDENT = "%4s";

    public static void main(String[] args) {

        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");

        String[] taskList = new String[MAX_TASKS];
        String userInput;
        int listNumber = 1;
        while (true) {
            userInput = new Scanner(System.in).nextLine();
            if (userInput.equals("bye")) {
                System.out.printf(INDENT + "Bye. Hope to see you again soon!", "");
                break;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < listNumber; i++) {
                    if (taskList[i] != null) {
                        System.out.printf(INDENT + "%s%n", "", taskList[i]);
                    }
                }
            } else {
                taskList[listNumber - 1] = listNumber + ". " + userInput;
                System.out.printf(INDENT + "Added: %s%n", "", userInput);
                listNumber++;
            }
        }
    }
}
