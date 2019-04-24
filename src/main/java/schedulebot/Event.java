
package schedulebot;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * Event class for the creation of a scheduled event :)
 *
 * @author Alex L
 *
 */

public class Event extends ListenerAdapter {
    private int id;
    private String name, timeStart, timeEnd;;
    private User[] invited, going, declined;

    public Event(String name, String timeStart, String timeEnd) {
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        /*
        this.invited = invited; // need time for my peanut brain to figure out how to implement this
        this.going = going;
        this.declined = declined;
        */
    }

    public Event() {
        this.name = "";
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String eventName) {
        this.name = eventName;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public User[] getInvited() {
        return invited;
    }

    public void setInvited(User[] invited) {
        this.invited = invited;
    }

    public User[] getGoing() {
        return going;
    }

    public void setGoing(User[] going) {
        this.going = going;
    }

    public User[] getDeclined() {
        return declined;
    }

    public void setDeclined(User[] declined) {
        this.declined = declined;
    }
}

