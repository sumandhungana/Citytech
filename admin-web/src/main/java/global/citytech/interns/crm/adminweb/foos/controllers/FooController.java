package global.citytech.interns.crm.adminweb.foos.controllers;

import global.citytech.interns.crm.adminweb.foos.converters.FooPayloadConverter;
import global.citytech.interns.crm.adminweb.foos.models.Foo;
import global.citytech.interns.crm.adminweb.foos.models.FooDto;
import global.citytech.interns.crm.adminweb.foos.views.AddFooForm;
import global.citytech.interns.crm.adminweb.foos.views.EditFooForm;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.payloads.AddFooRequest;
import global.citytech.interns.crm.services.foos.payloads.GetAllFoosRequest;
import global.citytech.interns.crm.services.foos.payloads.GetAllFoosResponse;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;
import global.citytech.interns.crm.services.foos.usecases.AddFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetAllFoosUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

@Path("foos")
@Controller
@RequestScoped
public class FooController {

    private final String LIST_PAGE= "foos/list.xhtml";
    private final String ADD_PAGE = "foos/add.xhtml";
    private final String MODIFY_PAGE = "foos/edit.xhtml";

    @Inject
    private Models models;

    @Inject
    private BindingResult validationResult;

    @Inject
    private AddFooUseCase addFooUseCase;

    @Inject
    private GetAllFoosUseCase getAllFoosUseCase;

    public FooController() {
    }

    public FooController(AddFooUseCase addFooUseCase, GetAllFoosUseCase getAllFoosUseCase) {
        this.addFooUseCase = addFooUseCase;
        this.getAllFoosUseCase = getAllFoosUseCase;
    }

    @GET
    public String getList() {
        GetAllFoosRequest request = new GetAllFoosRequest();
        GetAllFoosResponse response = this.getAllFoosUseCase.execute(UseCaseContext.emptyContext(), request);

        FooPayloadConverter payloadConverter = new FooPayloadConverter();

        if(response == null){
            return  null;
        }

        List<Foo> foos = payloadConverter.toResponseList(response.list());
        models.put("foos", foos);
        return LIST_PAGE;
    }

    @GET
    @Path("add")
    public String loadAddForm() {
        AddFooForm form = new AddFooForm();
        models.put("instance", form);
        return ADD_PAGE;
    }

    @POST
    public Response add(@Valid @BeanParam AddFooForm form) {
        if (validationResult.isFailed()) {
            Map<String,String> errors = new HashMap<>();
            validationResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        errors.put(t.getParamName(), t.getMessage());
                    });
            System.out.println("ERRORS = " + errors);
            models.put("message", "ERROR:"+ errors);
            models.put("instance", form);
            return Response.status(Response.Status.BAD_REQUEST).entity(ADD_PAGE).build();
        }
        //do add
        /*FooPayloadConverter converter = new FooPayloadConverter();
        FooInfo domainObj = converter.toRequest(form);
        */
        AddFooRequest addFooRequest = new AddFooRequest();
        addFooRequest.setName(form.getName());
        this.addFooUseCase.execute(UseCaseContext.emptyContext(), addFooRequest);
        //redirect to list page
        return Response.ok("redirect:foos").build();
    }

    @GET
    @Path("{id}/edit")
    public String loadEditForm() {
        EditFooForm form = new EditFooForm();
        form.setId("1001");
        form.setName("TEST");
        models.put("instance", form);
        return MODIFY_PAGE;
    }

    @PUT
    @Path("{id}")
    public Response update(@Valid @BeanParam AddFooForm form) {
        return Response.ok().build();
    }

}
