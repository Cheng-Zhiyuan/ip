package thoth.storage;

import thoth.tasks.Deadline;
import thoth.tasks.Event;
import thoth.tasks.Task;
import thoth.tasks.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Storage {

    private static final String DEFAULT_FILE_PATH = "C:\\CS2113_IP\\data\\data.txt";
    private static final int MIN_HEADER_SIZE = 7;
    private static final int TYPE_INDEX = 1;
    private static final int DONE_INDEX = 4;

    public static void createFile() throws IOException {
        File file = new File(DEFAULT_FILE_PATH);

        // Ensure the parent directories exist (if there are any)
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        // Create the file if it doesn't already exist
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void writeFile(String input) throws IOException {
        try (FileWriter fw = new FileWriter(DEFAULT_FILE_PATH, true)) {
            fw.append(input).append(System.lineSeparator());
        }
    }

    public static void saveTasks(List<Task> tasks) throws IOException {
        try (FileWriter fw = new FileWriter(DEFAULT_FILE_PATH, false)) {
            for (Task t : tasks) {
                fw.write(t.getTaskString() + System.lineSeparator());
            }
        }
    }

    public static List<Task> loadTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();
        File f = new File(DEFAULT_FILE_PATH);
        if (!f.exists()) {
            return tasks; // no file => no tasks
        }

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                Task t = parseLineToTask(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        }

        return tasks;
    }

    private static Task parseLineToTask(String line) {

        if (line.length() < MIN_HEADER_SIZE) {
            // Not in the expected format
            return null;
        }

        char taskType = line.charAt(TYPE_INDEX);  // 'D', 'T', or 'E'
        char doneChar = line.charAt(DONE_INDEX);  // ' ' or 'X'
        boolean isDone = (doneChar == 'X');

        // The rest of the line, e.g. "sleep (by: 15pm)"
        String content = line.substring(MIN_HEADER_SIZE).trim();

        switch(taskType) {
        case 'T': {
            // e.g. "[T][X] eat" => content = "eat"
            Todo todo = new Todo(content);
            if (isDone) {
                todo.markAsDone();
            }
            return todo;
        }
        case 'D': {
            // e.g. "[D][ ] sleep (by: 15pm)" => content = "sleep (by: 15pm)"
            // Find "(by: "
            int byIndex = content.indexOf("(by:");
            if (byIndex == -1) {
                // Not well-formed, handle error or return a default
                return null;
            }
            // description is everything before "(by:"
            String description = content.substring(0, byIndex).trim();
            // "15pm)" => remove the trailing ")"
            String byPart = content.substring(byIndex + 5).trim(); // skip "(by:"
            if (byPart.endsWith(")")) {
                byPart = byPart.substring(0, byPart.length() - 1).trim();
            }

            Deadline d = new Deadline(description, byPart);
            if (isDone) {
                d.markAsDone();
            }
            return d;
        }
        case 'E': {
            // e.g. "[E][ ] sleep and eat (from: 1am to: 6pm)"
            // content might be "sleep and eat (from: 1am to: 6pm)"
            // find "(from:"
            int fromIndex = content.indexOf("(from:");
            if (fromIndex == -1) {
                return null;
            }
            String description = content.substring(0, fromIndex).trim();
            // e.g. "1am to: 6pm)"
            String fromPart = content.substring(fromIndex + 6).trim(); // skip "(from:"

            // parse fromPart => "1am to: 6pm)"
            // find "to:"
            int toIndex = fromPart.indexOf("to:");
            if (toIndex == -1) {
                return null;
            }
            String fromTime = fromPart.substring(0, toIndex).trim(); // e.g. "1am"
            String toPart = fromPart.substring(toIndex + 3).trim();  // e.g. "6pm)"

            // remove trailing ")" if present
            if (toPart.endsWith(")")) {
                toPart = toPart.substring(0, toPart.length() - 1).trim();
            }

            // Now create the event
            Event e = new Event(description, fromTime, toPart);
            if (isDone) {
                e.markAsDone();
            }
            return e;
        }
        default:
            // Unknown task type
            return null;
        }
    }

}
