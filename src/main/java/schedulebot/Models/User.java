package schedulebot.Models;

/**
 * @author Justin Ho
 */
public class User {
    private Integer id;
    private String discord_name;
    private Integer discord_tag;

    /**
     * default constructor
     */
    public User() { }

    /**
     * create new User instance with Discord user
     */
    public User(String name, Integer tag) {
        this.discord_name = name;
        this.discord_tag = tag;
    }

    // accessors
    public String getName() { return discord_name; }
    public Integer getTag() { return discord_tag; }
    public String getDisplayName() { // change to Discord username format for @mention operations
        // format tag number to 4 digit string
        String tag = String.format("%1$4s", discord_tag).replace(" ", "0");
        String displayName = discord_name + "#" + tag;
        return displayName;
    }

    // mutators
    public void setName(String name) { this.discord_name = name; }
    public void setTag(Integer tag) { this.discord_tag = tag; }
}
