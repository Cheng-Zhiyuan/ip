package thoth.tasks;

public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a Deadline task with the specified description and deadline.
     *
     * @param description the description for the deadline task
     * @param by          the deadline for the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Return a String to representing the deadline task including it type and deadline
     *
     * @return the formatted string
     */
    @Override
    public String getTaskString() {
        return "[D]" + super.getTaskString() + " (by: " + by + ")";
    }
}

