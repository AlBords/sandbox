package sandbox.webserver;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
    	Optional<Properties> configuration = Configuration.loadProperties();
    	if (configuration.isEmpty()) {
            LOGGER.log(Level.SEVERE, "Cannot load configuration file.");
    		System.exit(1);
    	}
        int port = Integer.parseInt(configuration.get().getProperty("webserver.port", "80"));
		var addr = new InetSocketAddress(port);
        String docPath = configuration.get().getProperty("webserver.doc.path");
		var server = SimpleFileServer.createFileServer(addr, Path.of(docPath), OutputLevel.INFO);
        server.start();
        System.out.println("Hello Web!");
    }
}