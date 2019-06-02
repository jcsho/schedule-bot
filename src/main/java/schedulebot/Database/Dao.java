package schedulebot.Database;

import java.util.List;

/**
 * Interface for all Data Access Objects
 * @author Justin Ho
 * @version 0.1.0
 * @param <T> entity
 */
public interface Dao<T> {
    /**
     * Retrieve all objects from the database
     * @return list of all objects of type T
     */
    List<T> getAll();

    /**
     * Insert object t into the database
     * @param t - object to be inserted
     * @return true if the object has been found
     */
    boolean insert(T t);

    /**
     * Update object t in the database
     * @param t - object to be modified
     * @return true if the object has been found and modified
     */
    boolean update(T t);

    /**
     * Delete object t in the database
     * @param t - object to be deleted
     * @return true if the object has been found and deleted
     */
    boolean delete(T t);
}
