package schedulebot.Database;

import schedulebot.Models.Event;

import java.util.List;

public class EventDao implements Dao<Event> {
    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public boolean insert(Event event) {
        return false;
    }

    @Override
    public boolean update(Event event, String[] params) {
        return false;
    }

    @Override
    public boolean delete(Event event) {
        return false;
    }
}
