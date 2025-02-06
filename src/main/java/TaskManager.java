// For Task commands
public class TaskManager {
    public static final int MAX_TASKS = 100;
    private Task[] taskList = new Task[MAX_TASKS];
    private int taskCount = 0;

    public void addTask(Task task) {
        taskList[taskCount] = task;
        taskCount++;
        UserInterface.printMessage("Added: " + task.getTaskString());
    }

    public void markTaskAsDone(int taskId) {
        taskList[taskId].markAsDone();

    }

    public void printTaskList() {
        UserInterface.printTask(taskList, taskCount);
    }

    public void markTaskAsNotDone(int taskId) {
        taskList[taskId].markAsNotDone();
    }
}
