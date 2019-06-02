package schedulebot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import schedulebot.Database.DBManager;
import schedulebot.Database.UserDao;
import schedulebot.Models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test for {@link schedulebot.Database.UserDao UserDao}
 * @author Justin Ho
 * @version 0.1.0
 */
public class UserDaoTest {

    @Mock
    private DBManager db = new DBManager();

    @Mock
    private Connection c;

    @Mock
    private ResultSet rs;

    @Mock
    private Statement stmt;

    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        when(db.getConnection()).thenReturn(c);
        when(db.getConnection().createStatement()).thenReturn(stmt);

        user = new User();
        user.setName("test");
        user.setTag(8888);

        when(rs.next()).thenReturn(true);
        when(rs.getString("discord_name")).thenReturn(user.getName());
        when(rs.getInt("discord_tag")).thenReturn(user.getTag());
        when(stmt.executeQuery(any(String.class))).thenReturn(rs);
    }

    @Test
    public void getUserFromDB() {
        UserDao userDao = new UserDao(db);
        User test = userDao.getUser(user.getName());
        assertEquals(user, test);
    }
}
