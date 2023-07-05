package sandbox.appserver;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/")
@Produces(MediaType.APPLICATION_JSON)
public class ServerApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ServerAvailability.class);
        return resources;
    }
}
