package schedulebot.Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Justin Ho
 */
public class Event {
    private String name;
    private Calendar startDate;
    private Calendar endDate;
    private String description;
    private String location; //TODO decide how to handle location data
    private Calendar createdAt;
    private List<User> attendees;

    /**
     * default constructor
     */
    public Event() {
        this.createdAt = Calendar.getInstance();
        this.attendees = new ArrayList<>();
    }

    /**
     * Create a singular event
     *
     * @param name - event name
     * @param startDate - date event occurs
     */
    public Event(String name, Calendar startDate) {
        this.name = name;
        this.startDate = startDate;
        this.createdAt = Calendar.getInstance();
        this.attendees = new ArrayList<>();
    }

    /**
     * Create spanning event
     *
     * @param name - event name
     * @param startDate - event start date
     * @param endDate - event end date
     */
    public Event(String name, Calendar startDate, Calendar endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = Calendar.getInstance();
        this.attendees = new ArrayList<>();
    }

    // accessors
    public String getName() { return name; }
    public Calendar getStartDate() { return startDate; }
    public Calendar getEndDate() { return endDate; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public Calendar getCreatedAt() { return createdAt; }
    public List<User> getAttendees() { return attendees; }

    // mutators
    public void setName(String name) { this.name = name; }
    public void setStartDate(Calendar startDate) { this.startDate = startDate; }
    public void setEndDate(Calendar endDate) { this.endDate = endDate; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void addAttendee(User user) { this.attendees.add(user); }
    public void removeAttendee(User user) { this.attendees.remove(user); }
}
