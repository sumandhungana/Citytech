package global.citytech.interns.cms.adminwebjsf.users.controllers;

import global.citytech.interns.cms.adminwebjsf.users.converters.UserPayloadConverter;
import global.citytech.interns.cms.adminwebjsf.users.models.User;
import global.citytech.interns.cms.adminwebjsf.users.models.UserDto;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;

import global.citytech.interns.crm.services.users_jsf.payloads.*;

import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;
import global.citytech.interns.crm.services.users_jsf.usecases.AddUserUseCase;
import global.citytech.interns.crm.services.users_jsf.usecases.EditUserUseCase;
import global.citytech.interns.crm.services.users_jsf.usecases.GetAllUsersUseCase;
import global.citytech.interns.crm.services.users_jsf.usecases.GetUserUseCase;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class UserController implements Serializable {

    private final String LIST_PAGE = "pretty:users";

    User instance;
    String selectedItem;
    List<User> list;


    private GetAllUsersUseCase getAllUsersUseCase;

    private GetUserUseCase getUserUseCase;

    private AddUserUseCase addUserUseCase;

    private EditUserUseCase editUserUseCase;

    public UserController() {
    }
    @Inject
    public UserController(GetAllUsersUseCase getAllUsersUseCase, GetUserUseCase getUserUseCase, AddUserUseCase addUserUseCase, EditUserUseCase editUserUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getUserUseCase = getUserUseCase;
        this.addUserUseCase = addUserUseCase;
        this.editUserUseCase = editUserUseCase;
    }

    public User getInstance() {
        return instance;
    }

    public void setInstance(User instance) {
        this.instance = instance;
    }



    public void loadList() {
        GetAllUsersResponse response = this.getAllUsersUseCase.execute(UseCaseContext.emptyContext(), new GetAllUsersRequest());
        if(response == null){
            return;
        }

        UserPayloadConverter payloadConverter = new UserPayloadConverter();
        this.list = payloadConverter.toResponseList(response.list());
    }

    public List<User> getList() {
        return list;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String itemValue){
        this.selectedItem = itemValue;
    }

    public void loadAddForm(){
        if(this.instance == null) {
            this.     instance = new UserDto();
        }
    }

    public void loadSelectedItem() {
        if(this.instance != null){
            return;
        }
        GetUserRequest request = new GetUserRequest();
        request.setId(this.selectedItem);
        GetUserResponse response = this.getUserUseCase.execute(UseCaseContext.emptyContext(), request);

        UserInfo info = response.getUserInfo();
        UserPayloadConverter payloadConverter = new UserPayloadConverter();
        this.instance  = payloadConverter.toResponse(info);
    }

    public String onSave(){
        if(this.instance.getId() == null){
            this.add();
        }else{
            this.edit();
        }
        return LIST_PAGE;
    }

    private void add(){
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setName(this.instance.getName());
        addUserRequest.setBranch(this.instance.getBranch());
        addUserRequest.setStaffid(this.instance.getStaffid());
        addUserRequest.setEmail(this.instance.getEmail());
        addUserRequest.setRole(this.instance.getRole());
        this.addUserUseCase.execute(UseCaseContext.emptyContext(), addUserRequest);
    }


    private void edit(){
        System.out.println("INSTANCE ID = "+ this.instance.getId());
        System.out.println("INSTANCE NAME = "+ this.instance.getName());
        EditUserRequest editUserRequest = new EditUserRequest();
        editUserRequest.setId(this.instance.getId());
        editUserRequest.setName(this.instance.getName());
        editUserRequest.setEmail(this.instance.getEmail());
        editUserRequest.setStaffid(this.instance.getStaffid());
        editUserRequest.setRole(this.instance.getRole());
        editUserRequest.setBranch(this.instance.getBranch());
        this.editUserUseCase.execute(UseCaseContext.emptyContext(), editUserRequest);

    }
}

