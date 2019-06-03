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
   * Default constructor.
   * @param filename - file to check
   * @throws URISyntaxException - file path is formatted incorrectly
   * @throws IOException - cannot find file
   */
  public PropertiesHandler(String filename) throws IOException {
    this.fileName = filename;
    initializaProperties();
  }

  private void initializaProperties() throws IOException {
    properties = new Properties();

    String path = "src/main/resources/" + fileName + ".properties";
    file = new File(path);

    properties.load(new FileInputStream(file));
  }

  /**
   * Get property from config file.
   * @param key - string value of property
   * @return string of property key
   */
  public String get(String key) {
    return properties.getProperty(key);
  }
}
