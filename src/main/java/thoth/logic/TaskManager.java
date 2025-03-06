package thoth.logic;

import thoth.tasks.Task;

import java.util.ArrayList;
import java.util.List;

// For Task commands
public class TaskManager {

    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void markTaskAsDone(int taskId) {
        taskList.get(taskId).markAsDone();
    }

    public void markTaskAsNotDone(int taskId) {
        taskList.get(taskId).markAsNotDone();
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void removeTask(int taskId) {
        taskList.remove(taskId);
    }

    public List<Task> getTask(int taskId) {
        return taskList.subList(taskId, taskList.size());
    }
}
