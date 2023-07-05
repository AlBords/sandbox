package sandbox.appserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("isServerAvailable")
public class ServerAvailability {

    @GET
	public Response getServerAvailability() {
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(Boolean.TRUE).build();
	}
}
