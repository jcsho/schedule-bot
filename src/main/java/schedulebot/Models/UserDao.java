package schedulebot.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justin Ho
 */
public class UserDao implements Dao<User> {
    private List<User> users;

    public UserDao() {
        users = new ArrayList<>();
    }

    public User get(String name, Integer id) {
        return null;
    }

    @Override
    public List getAll() {
        // TODO get all users from User table
        return users;
    }

    @Override
    public boolean insert(User user) {
        // TODO insert new row into User table
        return false;
    }

    @Override
    public boolean update(User user , String[] params) {
        // TODO modify row from User table
        return false;
    }

    @Override
    public boolean delete(User user) {
        // TODO delete row from User table
        return false;
    }
}
