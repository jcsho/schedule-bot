package schedulebot.Database;

import schedulebot.PropertiesHandler;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class.getName());
    private final String file = "db-credentials";
    private String url, user, pwd;
    private Connection db;


    public DBManager() {
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

    public void connect() {
        try {
            this.db = DriverManager.getConnection(url, user, pwd);
            LOG.fine("Connected to database: " + url);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Failed to connect to database: " + url, e);
        }
    }

    public void disconnect() {
            try {
                db.close();
                LOG.fine("Connection to " + url + " closed");
            } catch (SQLException e) {
                LOG.log(Level.SEVERE, "Could not close connection ", e);
            }
    }

    public Connection getConnection() { return db; }

    public ResultSet query(String arg) {
        ResultSet rs = null;
        try {
            connect();
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery(arg);
            stmt.close();
            LOG.fine("Executed SQL query: " + arg);
        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Could not execute query ", e);
        } finally {
            disconnect();
        }

        if (rs == null) throw new Error("Could not find anything");
        return rs;
    }
}
