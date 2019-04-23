package schedulebot.Models;

import java.util.List;

/**
 * @param <T> entity
 * @author Justin Ho
 */
public interface Dao<T> {
    public List<T> getAll();
    public boolean insert(T t);
    public boolean update(T t, String[] params);
    public boolean delete(T t);
}
