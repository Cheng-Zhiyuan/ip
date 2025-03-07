/**
 * Manages a list of tasks.
 * <p>
 * This class provides methods to add tasks, mark them as done or not done, remove tasks,
 * and retrieve tasks or the task count.
 */
package thoth.logic;

import thoth.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> taskList = new ArrayList<>();

    /**
     * Add a new task to the task list.
     *
     * @param task is the task to be added
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Marks the task at the specific task index as done
     *
     * @param taskId the index of th task that needs to be mark as done
     */
    public void markTaskAsDone(int taskId) {
        taskList.get(taskId).markAsDone();
    }

    /**
     * Marks the task at the specific task index as not done
     *
     * @param taskId the index of th task that needs to be mark as not done
     */
    public void markTaskAsNotDone(int taskId) {
        taskList.get(taskId).markAsNotDone();
    }

    /**
     * Return the number of tasks in the task list
     *
     * @return the size of the task list
     */
    public int getTaskCount() {
        return taskList.size();
    }

    /**
     * Return the complete list of tasks
     *
     * @return the list of tasks
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     *  Remove the task at the specific task index
     *
     * @param taskId the index of tht task to be removed
     */
    public void removeTask(int taskId) {
        taskList.remove(taskId);
    }

    /**
     * Return a sublist of tasks from the specified index to the end of the list
     *
     * @param taskId the tarting index for the sublist
     * @return a list of tasks starting from the specified index
     */
    public List<Task> getTask(int taskId) {
        return taskList.subList(taskId, taskList.size());
    }
}
