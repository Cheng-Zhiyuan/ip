public class Event extends Task {

    protected String dateRange;

    public Event(String description, String dateRange, String to) {
        super(description);
        this.dateRange = dateRange;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + dateRange + ")";
    }
}
