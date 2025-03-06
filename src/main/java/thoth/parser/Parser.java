package thoth.parser;

import thoth.command.*;

public class Parser {

    public static final int INDEX_OFFSET = 1;

    public static Command parse(String userInput) {
        userInput = userInput.trim();

        if (userInput.equals("bye")) {
            return new ExitCommand();
        } else if (userInput.equals("list")) {
            return new ListCommand();
        } else if (userInput.startsWith("mark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.replace("mark", "").trim()) - INDEX_OFFSET;
                return new MarkCommand(taskIndex);
            } catch (NumberFormatException e) {
                return new UnknownCommand("Please enter a valid number for mark command.");
            }
        } else if (userInput.startsWith("unmark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.replace("unmark", "").trim()) - INDEX_OFFSET;
                return new UnmarkCommand(taskIndex);
            } catch (NumberFormatException e) {
                return new UnknownCommand("Please enter a valid number for unmark command.");
            }
        } else if (userInput.startsWith("delete")) {
            try {
                int taskIndex = Integer.parseInt(userInput.replace("delete", "").trim()) - INDEX_OFFSET;
                return new DeleteCommand(taskIndex);
            } catch (NumberFormatException e) {
                return new UnknownCommand("Please enter a valid number for delete command.");
            }
        } else if (userInput.startsWith("todo")) {
            String description = userInput.replace("todo", "").trim();
            if (description.isEmpty()) {
                return new UnknownCommand("Oops task description is empty");
            }
            return new TodoCommand(description);
        } else if (userInput.startsWith("deadline")) {
            String[] parts = userInput.replace("deadline", "").trim().split(" /by ");
            String description = parts[0].trim();
            String by = (parts.length > 1) ? parts[1].trim() : "";
            if (description.isEmpty() || by.isEmpty()) {
                return new UnknownCommand("Oops task description is empty or deadline not specified");
            }
            return new DeadlineCommand(description, by);
        } else if (userInput.startsWith("event")) {
            String[] parts = userInput.replace("event", "").trim().split(" /from ");
            String description = parts[0].trim(); // Extracts "meeting"
            String from = "";
            String to = "";
            if (parts.length > 1) {
                String[] timeParts = parts[1].split(" /to ");
                from = timeParts[0].trim(); // Extracts "2pm"
                if (timeParts.length > 1) {
                    to = timeParts[1].trim(); // Extracts "4pm"
                }
            }
            if (description.isEmpty() || to.isEmpty() || from.isEmpty()) {
                return new UnknownCommand("Oops task description is empty or time range not specified");
            }
            return new EventCommand(description, from, to);

        }else {
            return new UnknownCommand("Oops me no understand you~");
        }
    }
}
