package thoth.tasks;

public class Event extends Task {

    protected String to;
    protected String from;

    /**
     * Constructs the Event Task with specified description, start and end time of the event
     *
     * @param description the description of the event
     * @param from        the starting time of the event
     * @param to          the ending time of the event
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Return a string representing the event with its type and start and end timeframe
     *
     * @return the formatted task string
     */
    @Override
    public String getTaskString() {
        return "[E]" + super.getTaskString() + " (from: " + from + " to: " + to + ")";
    }
}
