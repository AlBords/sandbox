package sandbox.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {
    public static Optional<Properties> loadProperties() {
        String webserverConfigurationFileName = "configuration.properties";
		try (InputStream stream = 
				Configuration.class.getClassLoader().getResourceAsStream(webserverConfigurationFileName)) {
            Properties properties = new Properties();
            properties.load(stream);
            return Optional.of(properties);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
