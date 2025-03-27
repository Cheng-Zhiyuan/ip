package thoth.parser;

import thoth.tasks.Deadline;
import thoth.tasks.Event;
import thoth.tasks.Task;
import thoth.tasks.Todo;
import thoth.exceptions.TaskParsingException;

/**
 * Provides functionality to parse a line from the storage file into a Task object.
 */
public class TaskParser {
    private static final int MIN_HEADER_SIZE = 7;
    private static final int TYPE_INDEX = 1;
    private static final int DONE_INDEX = 4;

    /**
     * Main method to parse a storage file line into a Task.
     *
     * @param line the storage file line.
     * @return the corresponding Task object.
     * @throws TaskParsingException if the line is not in the expected format.
     */
    public static Task parseLineToTask(String line) throws TaskParsingException {
        if (line.length() < MIN_HEADER_SIZE) {
            throw new TaskParsingException("Line too short to parse: " + line);
        }

        char taskType = line.charAt(TYPE_INDEX);
        char doneChar = line.charAt(DONE_INDEX);
        boolean isDone = (doneChar == 'X');
        String content = line.substring(MIN_HEADER_SIZE).trim();

        switch (taskType) {
        case 'T':
            return parseTodo(content, isDone);
        case 'D':
            return parseDeadline(content, isDone);
        case 'E':
            return parseEvent(content, isDone);
        default:
            throw new TaskParsingException("Unknown task type: " + taskType + " in line: " + line);
        }
    }

    /**
     * Helper method to parse a Todo task.
     *
     * @param content the content of the task.
     * @param isDone  whether the task is marked as done.
     * @return the Todo task.
     * @throws TaskParsingException if the content is empty.
     */
    private static Task parseTodo(String content, boolean isDone) throws TaskParsingException {
        if (content.isEmpty()) {
            throw new TaskParsingException("Todo description is empty.");
        }
        Todo todo = new Todo(content);
        if (isDone) {
            todo.markAsDone();
        }
        return todo;
    }

    /**
     * Helper method to parse a Deadline task.
     *
     * @param content the content of the task.
     * @param isDone  whether the task is marked as done.
     * @return the Deadline task.
     * @throws TaskParsingException if the '(by:' delimiter is missing or parts are empty.
     */
    private static Task parseDeadline(String content, boolean isDone) throws TaskParsingException {
        int byIndex = content.indexOf("(by:");
        if (byIndex == -1) {
            throw new TaskParsingException("Deadline task is missing '(by:' section: " + content);
        }
        String description = content.substring(0, byIndex).trim();
        String byPart = content.substring(byIndex + 5).trim(); // skip "(by:"
        if (byPart.endsWith(")")) {
            byPart = byPart.substring(0, byPart.length() - 1).trim();
        }
        if (description.isEmpty() || byPart.isEmpty()) {
            throw new TaskParsingException("Deadline description or deadline time is empty: " + content);
        }
        Deadline deadline = new Deadline(description, byPart);
        if (isDone) {
            deadline.markAsDone();
        }
        return deadline;
    }

    /**
     * Helper method to parse an Event task.
     *
     * @param content the content of the task.
     * @param isDone  whether the task is marked as done.
     * @return the Event task.
     * @throws TaskParsingException if the '(from:' or 'to:' delimiters are missing or parts are empty.
     */
    private static Task parseEvent(String content, boolean isDone) throws TaskParsingException {
        int fromIndex = content.indexOf("(from:");
        if (fromIndex == -1) {
            throw new TaskParsingException("Event task is missing '(from:' section: " + content);
        }
        String description = content.substring(0, fromIndex).trim();
        String fromPart = content.substring(fromIndex + 6).trim(); // skip "(from:"
        int toIndex = fromPart.indexOf("to:");
        if (toIndex == -1) {
            throw new TaskParsingException("Event task is missing 'to:' section in: " + content);
        }
        String fromTime = fromPart.substring(0, toIndex).trim();
        String toPart = fromPart.substring(toIndex + 3).trim();  // skip "to:"
        if (toPart.endsWith(")")) {
            toPart = toPart.substring(0, toPart.length() - 1).trim();
        }
        if (description.isEmpty() || fromTime.isEmpty() || toPart.isEmpty()) {
            throw new TaskParsingException("Event description or time range is empty: " + content);
        }
        Event event = new Event(description, fromTime, toPart);
        if (isDone) {
            event.markAsDone();
        }
        return event;
    }
}
