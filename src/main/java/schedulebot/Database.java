package schedulebot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final Logger LOG = Logger.getLogger(Database.class.getName());
    private final String file = "db-credentials";
    private String url, user, pwd;
    private Connection db;


    public Database() {
        try {
            this.db = null;
            PropertiesHandler dbCredentials = new PropertiesHandler(file);
            this.url = dbCredentials.get("dbUrl");
            this.user = dbCredentials.get("dbUser");
            this.pwd = dbCredentials.get("dbPass");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cannot find file: " + file, e);
        }
    }

    private void connect() {
        try {
            this.db = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Failed to connect to database: " + url, e);
        }
        LOG.fine("Connected to database: " + url);
    }

    private void disconnect() {
            try {
                db.close();
                LOG.fine("Connection to " + url + " closed");
            } catch (SQLException e) {
                LOG.log(Level.SEVERE, "Could not close connection ", e);
            }
    }

    public void createTable() {
        try {
            connect();
            Statement query = db.createStatement();
            String createUserTable = "CREATE TABLE IF NOT EXIST User " +
                    "(id INT PRIMARY KEY NOT NULL, " +
                    "discord_name varchar(255) " +
                    "discord_tag int(4) " +
                    ");";
            query.execute(createUserTable);
            query.close();
            LOG.fine("Executed SQL query: " + createUserTable);
        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Could not create table ", e);
        } finally {
            disconnect();
        }
    }
}
