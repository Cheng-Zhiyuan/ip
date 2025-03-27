/**
 * Provides functionality to parse user input into executable commands.
 */
package thoth.parser;

import thoth.command.Command;
import thoth.command.DeadlineCommand;
import thoth.command.EventCommand;
import thoth.command.MarkCommand;
import thoth.command.UnmarkCommand;
import thoth.command.ExitCommand;
import thoth.command.FindCommand;
import thoth.command.ListCommand;
import thoth.command.TodoCommand;
import thoth.command.DeleteCommand;

import thoth.exceptions.ThothException;

public class Parser {

    private static final int INDEX_OFFSET = 1;

    /**
     * Parses the user input into the corresponding executable command.
     *
     * @param userInput the input string provided by the user.
     * @return the Command object corresponding to the user input.
     */
    public static Command parse(String userInput) throws ThothException {
        String commandWord = userInput.split(" ")[0].trim();

        if (userInput.equals("bye")) {
            return new ExitCommand();
        } else if (userInput.equals("list")) {
            return new ListCommand();
        } else if (commandWord.equals("mark")) {
            return parseMarkCommand(userInput);
        } else if (commandWord.equals("unmark")) {
            return parseUnmarkCommand(userInput);
        } else if (commandWord.equals("delete")) {
            return parseDeleteCommand(userInput);
        } else if (commandWord.equals("todo")) {
            return parseTodoCommand(userInput);
        } else if (commandWord.equals("deadline")) {
            return parseDeadlineCommand(userInput);
        } else if (commandWord.equals("event")) {
            return parseEventCommand(userInput);
        } else if (commandWord.equals("find")) {
            return parseFindCommand(userInput);
        } else {
            throw new ThothException("Opps, me no understand that command: " + userInput);
        }
    }


    /**
     * Parses a command starting with "mark" and returns the corresponding MarkCommand.
     *
     * @param input the input string starting with "mark".
     * @return a MarkCommand if the index is valid; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseMarkCommand(String input) throws ThothException {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new ThothException("Please provide a task number for the mark command.");
        }
        try {
            // parts[1] should contain the number
            int taskIndex = Integer.parseInt(parts[1].trim()) - Parser.INDEX_OFFSET;
            return new MarkCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new ThothException("Please enter a valid task index for the mark command.");
        }
    }


    /**
     * Parses a command starting with "unmark" and returns the corresponding UnmarkCommand.
     *
     * @param input the input string starting with "unmark".
     * @return an UnmarkCommand if the index is valid; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseUnmarkCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new ThothException("Please provide a task index for the unmark command.");
        }
        try {
            // parts[1] should contain the number
            int taskIndex = Integer.parseInt(parts[1].trim()) - Parser.INDEX_OFFSET;
            return new UnmarkCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new ThothException("Please enter a valid task index for unmark command.");
        }
    }

    /**
     * Parses a command starting with "delete" and returns the corresponding DeleteCommand.
     *
     * @param input the input string starting with "delete".
     * @return a DeleteCommand if the index is valid; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseDeleteCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new ThothException("Please provide a task index for the delete command.");
        }
        try {
            // parts[1] should contain the number
            int taskIndex = Integer.parseInt(parts[1].trim()) - Parser.INDEX_OFFSET;
            return new DeleteCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new ThothException("Please enter a valid task index for delete command.");
        }
    }

    /**
     * Parses a command starting with "todo" and returns the corresponding TodoCommand.
     *
     * @param input the input string starting with "todo".
     * @return a TodoCommand if the description is non-empty; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseTodoCommand(String input) {
        String description = input.replace("todo", "").trim();
        if (description.isEmpty()) {
            throw new ThothException("The description for the todo command is empty.");
        }
        return new TodoCommand(description);
    }

    /**
     * Parses a command starting with "deadline" and returns the corresponding DeadlineCommand.
     *
     * @param input the input string starting with "deadline".
     * @return a DeadlineCommand if both description and deadline are provided; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseDeadlineCommand(String input) {
        String[] parts = input.replace("deadline", "").trim().split(" /by ");
        String description = parts[0].trim();
        String by = (parts.length > 1) ? parts[1].trim() : "";
        if (description.isEmpty() || by.isEmpty()) {
            throw new ThothException("Oops task description is empty or time range not specified");
        }
        return new DeadlineCommand(description, by);
    }

    /**
     * Parses a command starting with "event" and returns the corresponding EventCommand.
     *
     * @param input the input string starting with "event".
     * @return an EventCommand if the description and time range are provided; otherwise, an UnknownCommand with an error message.
     */
    private static Command parseEventCommand(String input) {
        String[] parts = input.replace("event", "").trim().split(" /from ");
        String description = parts[0].trim();
        String from = "";
        String to = "";
        if (parts.length > 1) {
            String[] timeParts = parts[1].split(" /to ");
            from = timeParts[0].trim();
            if (timeParts.length > 1) {
                to = timeParts[1].trim();
            }
        }
        if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new ThothException("Oops task description is empty or time range not specified");
        }
        return new EventCommand(description, from, to);
    }

    /**
     * Parses a command starting with "find" and returns the corresponding FindCommand.
     *
     * @param input the input string starting with "find".
     * @return a FindCommand with the provided keyword.
     */
    private static Command parseFindCommand(String input) {
        String keyWord = input.replace("find", "").trim();
        return new FindCommand(keyWord);
    }
}
