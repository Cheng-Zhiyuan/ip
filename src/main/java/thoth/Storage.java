package thoth;

import thoth.parser.TaskParser;
import thoth.tasks.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Storage {

    private static final String DEFAULT_FILE_PATH = "data/data.txt";
    private static final int MIN_HEADER_SIZE = 7;
    private static final int TYPE_INDEX = 1;
    private static final int DONE_INDEX = 4;

    /**
     * Create a file to store data
     *
     * @throws IOException if an I/O error occurs while creating the file
     */
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

    /**
     * Add a new line into the file with the user input
     *
     * @param input the string to be written to the file
     * @throws IOException if an I/O error occurs while writing to this file
     */
    public static void writeFile(String input) throws IOException {
        try (FileWriter fw = new FileWriter(DEFAULT_FILE_PATH, true)) {
            fw.append(input).append(System.lineSeparator());
        }
    }

    /**
     * Saves the list of tasks into the data file
     *
     * @param tasks the task list that is to be saved
     * @throws IOException if an I/O error occurs while writing to this file
     */
    public static void saveTasks(List<Task> tasks) throws IOException {
        try (FileWriter fw = new FileWriter(DEFAULT_FILE_PATH, false)) {
            for (Task t : tasks) {
                fw.write(t.getTaskString() + System.lineSeparator());
            }
        }
    }

    /**
     * Load the task from the data file
     *
     * @return a list of tasks loaded from the file or an empty list if the file does not exist
     * @throws IOException if an I/O error occurs while writing to this file
     */
    public static List<Task> loadTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();
        File f = new File(DEFAULT_FILE_PATH);
        if (!f.exists()) {
            return tasks; // no file => no tasks
        }

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                Task t = TaskParser.parseLineToTask(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        }

        return tasks;
    }


}
