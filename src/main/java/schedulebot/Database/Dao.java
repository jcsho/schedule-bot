package schedulebot.Database;

import java.util.List;

/**
 * @param <T> entity
 * @author Justin Ho
 */
public interface Dao<T> {
    List<T> getAll();
    boolean insert(T t);
    boolean update(T t, String[] params);
    boolean delete(T t);
}
