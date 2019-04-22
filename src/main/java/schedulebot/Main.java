package schedulebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {

    /**
     * @throws Exception
     */
    public static void main() throws Exception {
        try {
            // read token property from bot-token.properties file
            String token = new PropertiesHandler("bot-token").get("token");
            // create new JDA instance
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            builder.setToken(token);
            // add !ping example
            builder.addEventListener(new Main());
            builder.build();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setup example for !ping command
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        System.out.println("We receieved a message from " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
