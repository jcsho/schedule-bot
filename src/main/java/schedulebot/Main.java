package schedulebot;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;



public class Main extends ListenerAdapter {

    public static String prefix = "/";
    public int state = 0;

    /**
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            // read token property from bot-token.properties file
            String token = new PropertiesHandler("bot-token").get("token");
            // create new JDA instance
            JDA builder = new JDABuilder(token).build();
            // add !ping example
            builder.addEventListener(new Main());
            builder.addEventListener(new Event());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setup example for !ping command
     *
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Event newEvent = new Event();
        String msg = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot()) return;

        System.out.println("We receieved a message from " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }
        switch (state) {
            case 0:
                if (msg.startsWith(prefix + "event new")) {
                    event.getChannel().sendMessageFormat("What would you like to call this event?").queue();
                    state = 1;
                } else {
                    event.getChannel().sendMessage("Ok then.").queue();
                }
                break;
            case 1:
                switch (msg) {
                    default:
                        newEvent.setName(msg);
                        event.getChannel().sendMessage("Event name set to: "+ newEvent.getName()).queue();
                        state = 2;
                } // to be cont.
        }
    }
}
