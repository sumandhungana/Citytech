package global.citytech.interns.crm.adminendpoints.users.controllers;

import global.citytech.interns.crm.services.users.payloads.AddUserRequest;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;
import global.citytech.interns.crm.services.users.usecases.AddUserUseCase;
import global.citytech.interns.crm.services.users.usecases.GetAllUsersUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private GetAllUsersUseCase getAllUsersUseCase;
    private AddUserUseCase addUserUseCase;

    public UserResource() {
    }

    @Inject
    public UserResource(GetAllUsersUseCase getAllUsersUseCase, AddUserUseCase addUserUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.addUserUseCase = addUserUseCase;
    }

    @GET
    public Response getAllUsers() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        return Response.ok(this.getAllUsersUseCase.execute(request).list()).build();
    }

    @POST
    public Response addUser(UserInfo user){
        AddUserRequest request = new AddUserRequest();
        request.setName(user.getName());
        request.setFullName(user.getFullName());
        return Response.ok(this.addUserUseCase.execute(request)).build();
    }
}
