import java.util.Scanner;
import java.util.Arrays;

public class Thoth {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Thoth");
        System.out.println("What can I do for you?");

        String userInput = null;
        while (true) {  
            userInput = new Scanner(System.in).nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(userInput);
            }
        }
    }
}
