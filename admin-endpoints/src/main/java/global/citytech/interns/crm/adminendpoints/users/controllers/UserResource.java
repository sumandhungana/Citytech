package global.citytech.interns.crm.adminendpoints.users.controllers;

import global.citytech.interns.crm.adminendpoints.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.adminendpoints.users.usecases.GetAllUsersUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private GetAllUsersUseCase getAllUsersUseCase;

    public UserResource() {
    }

    @Inject
    public UserResource(GetAllUsersUseCase getAllUsersUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @GET
    public Response getAllUsers() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        return Response.ok(this.getAllUsersUseCase.execute(request).list()).build();
    }
}
