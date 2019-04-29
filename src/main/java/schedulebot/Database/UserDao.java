package schedulebot.Database;

import schedulebot.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Justin Ho
 */
public class UserDao implements Dao<User> {
    private List<User> users;
    private DBManager db;

    /**
     * default constructor
     */
    public UserDao(DBManager db) {
        this.db = db;
        this.users = new ArrayList<>();
    }

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
    public boolean update(User user , String[] params) {
        // TODO modify row from User table
        return false;
    }

    @Override
    public boolean delete(User user) {
        // TODO delete row from User table
        return false;
    }

    private User extractFromRS(ResultSet rs) throws SQLException {
        User user = new User();

        user.setName(rs.getString("discord_name"));
        user.setTag(rs.getInt("discord_tag"));

        return  user;
    }
}
