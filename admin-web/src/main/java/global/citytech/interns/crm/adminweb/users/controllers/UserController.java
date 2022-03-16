package global.citytech.interns.crm.adminweb.users.controllers;

import global.citytech.interns.crm.adminweb.users.converters.UserPayloadConverter;
import global.citytech.interns.crm.adminweb.users.models.Users;
import global.citytech.interns.crm.adminweb.users.views.AddUserForm;
import global.citytech.interns.crm.adminweb.users.views.EditUserForm;
import global.citytech.interns.crm.services.users.payloads.*;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;
import global.citytech.interns.crm.services.users.usecases.AddUserUseCase;
import global.citytech.interns.crm.services.users.usecases.GetAllUsersUseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users.usecases.GetUserUseCase;
import global.citytech.interns.crm.services.users.usecases.EditUserUseCase;

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

@Path("users")
@Controller
@RequestScoped
public class UserController {

    private final String LIST_PAGE= "users/list.xhtml";
    private final String ADD_PAGE = "users/add.xhtml";
    private final String MODIFY_PAGE = "users/edit.xhtml";

    @Inject
    private Models models;

    @Inject
    private BindingResult validationResult;

    @Inject
    private GetUserUseCase getUserUseCase;

    @Inject
    private EditUserUseCase editUserUseCase;

    @Inject
    private GetAllUsersUseCase getAllUsersUseCase;

    @Inject
    private AddUserUseCase addUserUseCase;

    public UserController() {}

    public UserController(GetUserUseCase getUserUseCase,GetAllUsersUseCase getAllUserUseCase, AddUserUseCase addUserUseCase, EditUserUseCase editUserUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.addUserUseCase = addUserUseCase;
        this.editUserUseCase = editUserUseCase;
        this.getAllUsersUseCase = getAllUserUseCase;
    }

    @GET
    public String getList() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        GetAllUsersResponse response = this.getAllUsersUseCase.execute(UseCaseContext.emptyContext(), request);

        UserPayloadConverter payloadConverter = new UserPayloadConverter();

        if(response == null){
            return  null;
        }

        List<Users> users = payloadConverter.toResponseList(response.list());
        models.put("users", users);
        return LIST_PAGE;
    }

    @GET
    @Path("add")
    public String loadAddForm() {
        AddUserForm form = new AddUserForm();
        models.put("instance", form);
        return ADD_PAGE;

    }

    @POST
    public Response add(@Valid @BeanParam AddUserForm form) {
        if (validationResult.isFailed()) {
            Map<String, String> errors = new HashMap<>();
            validationResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        errors.put(t.getParamName(), t.getMessage());
                    });
            System.out.println("ERRORS = " + errors);
            models.put("message", "ERROR:" + errors);
            models.put("instance", form);
            return Response.status(Response.Status.BAD_REQUEST).entity(ADD_PAGE).build();
        }
        //do add
//        UserPayloadConverter converter = new UserPayloadConverter();
//        UserInfo domainObj = converter.toRequest(form);

        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setFullname(form.getFullname());
        addUserRequest.setUserrole(form.getUserrole());
        addUserRequest.setEmail(form.getEmail());
        addUserRequest.setMobile(form.getMobile());
        this.addUserUseCase.execute(UseCaseContext.emptyContext(), addUserRequest);
        //redirect to list page
        return Response.ok("redirect:users").build();
    }

    @GET
    @Path("{id}/edit")
    public String loadEditForm(@PathParam("id") String id) {
        GetUserRequest request = new GetUserRequest();
        request.setId(id);
        GetUserResponse response = this.getUserUseCase.execute(UseCaseContext.emptyContext(), request);
        UserInfo info = response.getUserInfo();
        UserPayloadConverter payloadConverter = new UserPayloadConverter();
        Users userForm  = payloadConverter.toResponse(info);
        models.put("instance", userForm);
        return MODIFY_PAGE;
    }

    @POST
    @Path("{id}")
    public Response update(@PathParam("id") String id, @Valid @BeanParam EditUserForm form) {
        System.out.println("HERE 1");
        if (validationResult.isFailed()) {
            System.out.println("HERE 2");
            return Response.status(Response.Status.BAD_REQUEST).entity(MODIFY_PAGE).build();
        }
        System.out.println("HERE 3");
        EditUserRequest editUserRequest = new EditUserRequest();
        editUserRequest.setId(form.getId());
        editUserRequest.setFullname(form.getFullname());
        editUserRequest.setUserrole(form.getUserrole());
        editUserRequest.setEmail(form.getEmail());
        editUserRequest.setMobile(form.getMobile());
        this.editUserUseCase.execute(UseCaseContext.emptyContext(), editUserRequest);
        System.out.println("Update phase in Controller");
        //redirect to list page
        System.out.println("HERE 4"+form.getEmail());

        return Response.ok("redirect:users").build();
    }
}
