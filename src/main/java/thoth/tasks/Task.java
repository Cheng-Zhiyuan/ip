package thoth.tasks;

public class Task {
    //parameters for checking and unchecking tasks
    public static final String EMPTY_BOX = "[ ]";
    public static final String MARKED_BOX = "[X]";

    protected String description;
    protected boolean isDone;

    /**
     * Constructs a task with the description
     *
     * @param description the description for the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * mark task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * mark task as not done
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task, including its completion status and description.
     *
     * @return the formatted task string
     */
    public String getTaskString() {
        String statusIcon = isDone ? MARKED_BOX : EMPTY_BOX;
        return statusIcon + " " + description;
    }
}
