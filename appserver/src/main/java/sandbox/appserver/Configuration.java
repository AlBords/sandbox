package sandbox.appserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Configuration {
    private static final Logger LOGGER = Logger.getLogger(Configuration.class.getName());

    public static Properties loadProperties() {
        try (InputStream stream = ServerApplication.class.getClassLoader().getResourceAsStream("configuration.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            LOGGER.severe("Cannot load configuration file.");
            return null;
        }
    }
}
