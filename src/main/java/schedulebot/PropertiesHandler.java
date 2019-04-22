package schedulebot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertiesHandler {

    private Properties properties;
    private String fileName;
    private File file;

    /**
     * @param filename
     * @throws URISyntaxException
     * @throws IOException
     */
    public PropertiesHandler(String filename) throws URISyntaxException, IOException {
        this.fileName = filename;
        initializaProperties();
    }

    private void initializaProperties() throws URISyntaxException, IOException {
        properties = new Properties();

        String path = "src/main/resources/" + fileName + ".properties";
        file = new File(path);

        properties.load(new FileInputStream(file));
    }

    /**
     *
     * @param key
     * @return String
     */
    public String get(String key) {
        return properties.getProperty(key);
    }
}
