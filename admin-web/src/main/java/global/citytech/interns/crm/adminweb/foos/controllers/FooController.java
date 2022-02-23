package global.citytech.interns.crm.adminweb.foos.controllers;

import global.citytech.interns.crm.adminweb.foos.converters.FooPayloadConverter;
import global.citytech.interns.crm.adminweb.foos.models.Foo;
import global.citytech.interns.crm.adminweb.foos.views.AddFooForm;
import global.citytech.interns.crm.adminweb.foos.views.EditFooForm;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.payloads.*;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;
import global.citytech.interns.crm.services.foos.usecases.AddFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.EditFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetAllFoosUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetFooUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private GetFooUseCase getFooUseCase;

    @Inject
    private AddFooUseCase addFooUseCase;

    @Inject
    private EditFooUseCase editFooUseCase;

    @Inject
    private GetAllFoosUseCase getAllFoosUseCase;

    public FooController() {
    }

    public FooController(GetFooUseCase getFooUseCase, AddFooUseCase addFooUseCase, EditFooUseCase editFooUseCase, GetAllFoosUseCase getAllFoosUseCase) {
        this.getFooUseCase = getFooUseCase;
        this.addFooUseCase = addFooUseCase;
        this.editFooUseCase = editFooUseCase;
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
    public String loadEditForm(@PathParam("id") String id) {
        GetFooRequest request = new GetFooRequest();
        request.setId(id);
        GetFooResponse response = this.getFooUseCase.execute(UseCaseContext.emptyContext(), request);

        FooInfo info = response.getFooInfo();
        FooPayloadConverter payloadConverter = new FooPayloadConverter();
        Foo fooForm  = payloadConverter.toResponse(info);
        models.put("instance", fooForm);
        return MODIFY_PAGE;
    }

    @POST
    @Path("{id}")
    public Response update(@PathParam("id") String id, @Valid @BeanParam EditFooForm form) {
        System.out.println("HERE 1");
        if (validationResult.isFailed()) {
            System.out.println("HERE 2");
            return Response.status(Response.Status.BAD_REQUEST).entity(MODIFY_PAGE).build();
        }
        System.out.println("HERE 3");
        EditFooRequest editFooRequest = new EditFooRequest();
        editFooRequest.setId(form.getId());
        editFooRequest.setName(form.getName());
        this.editFooUseCase.execute(UseCaseContext.emptyContext(), editFooRequest);
        //redirect to list page
        System.out.println("HERE 4");
        return Response.ok("redirect:foos").build();
    }

}
