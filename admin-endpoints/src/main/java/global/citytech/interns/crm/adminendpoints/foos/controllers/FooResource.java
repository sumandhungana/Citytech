package global.citytech.interns.crm.adminendpoints.foos.controllers;

import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.payloads.AddFooRequest;
import global.citytech.interns.crm.services.foos.payloads.GetAllFoosRequest;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;
import global.citytech.interns.crm.services.foos.usecases.AddFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetAllFoosUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("foos")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FooResource {

    private GetAllFoosUseCase getAllFoosUseCase;
    private AddFooUseCase addFooUseCase;

    public FooResource() {
    }

    @Inject
    public FooResource(GetAllFoosUseCase getAllFoosUseCase, AddFooUseCase addFooUseCase) {
        this.getAllFoosUseCase = getAllFoosUseCase;
        this.addFooUseCase = addFooUseCase;
    }

    @GET
    public Response getAllFoos() {
        GetAllFoosRequest request = new GetAllFoosRequest();
        return Response.ok(this.getAllFoosUseCase.execute(UseCaseContext.emptyContext(), request).list()).build();
    }

    @POST
    public Response addFoo(FooInfo info){
        AddFooRequest request = new AddFooRequest();
        request.setName(info.getName());
        return Response.ok(this.addFooUseCase.execute(UseCaseContext.emptyContext(), request)).build();
    }
}
