// For Task commands
public class TaskManager {
    public static final int MAX_TASKS = 100;
    private final Task[] taskList = new Task[MAX_TASKS];
    private int taskCount = 0;

    public void addTask(Task task) {
        taskList[taskCount] = task;
        taskCount++;
    }

    public void markTaskAsDone(int taskId) {
        taskList[taskId].markAsDone();
    }

    public void markTaskAsNotDone(int taskId) {
        taskList[taskId].markAsNotDone();
    }

    public int getTaskCount() {
        return taskCount;
    }

    public Task[] getTaskList() {
        return taskList;
    }
}
