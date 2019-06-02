package schedulebot.Database;

import schedulebot.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for the {@link schedulebot.Models.User User} Model
 * @author Justin Ho
 * @version 0.1.0
 */
public class UserDao implements Dao<User> {
    /**
     * List of all users in the db
     */
    private List<User> users;
    /**
     * Connection object of type {@link schedulebot.Database.DBManager DBManager}
     */
    private DBManager db;

    /**
     * default constructor
     */
    public UserDao(DBManager db) {
        this.db = db;
        this.users = new ArrayList<>();
    }

    /**
     * Get a single user from db by name
     * @param name - the discord name to search for
     * @return a {@link schedulebot.Models.User User} object matching param name
     */
    public User getUser(String name) {
        User user = null;
        try {
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * " +
                    "FROM \"user\" " +
                    "WHERE \"discord_name\"='" + name + "'");
            if (rs.next()) {
                user = extractFromRS(rs);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Return all users from the db
     * @return list of all users in db
     */
    @Override
    public List getAll() {
        try {
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"user\"");
            while (rs.next()) {
                users.add(extractFromRS(rs));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Could not get users");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean insert(User user) {
        // TODO insert new row into User table
        return false;
    }

    @Override
    public boolean update(User user) {
        // TODO modify row from User table
        return false;
    }

    @Override
    public boolean delete(User user) {
        // TODO delete row from User table
        return false;
    }

    /**
     * Format db result into {@link schedulebot.Models.User User} model
     * @param rs - result from db
     * @return a {@link schedulebot.Models.User User} object
     * @throws SQLException
     */
    private User extractFromRS(ResultSet rs) throws SQLException {
        User user = new User();

        user.setName(rs.getString("discord_name"));
        user.setTag(rs.getInt("discord_tag"));

        return  user;
    }
}
