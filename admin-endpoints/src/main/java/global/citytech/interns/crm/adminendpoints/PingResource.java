package global.citytech.interns.crm.adminendpoints;

import global.citytech.interns.crm.services.users.payloads.GetAllUsersRequest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ping")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

    @GET
    public Response doPing() {
        return Response.ok("Running admin-endpoints....").build();
    }
}
