package global.citytech.interns.crm.adminweb.users.controllers;

import global.citytech.interns.crm.adminweb.users.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.ArrayList;
import java.util.List;

@Path("users")
@Controller
@RequestScoped
public class UserController {

    @Inject
    private Models models;

    @GET
    @View("users/list.xhtml")
    public void getList() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "USER ONE"));
        users.add(new User("user2","USER TWO"));
        users.add(new User("user3","USER THREE"));
        models.put("totalRecords", users.size());
        models.put("users", users);
    }

    @GET
    @Path("list")
    @View("users/list.xhtml")
    public void getList2() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "USER ONE"));
        users.add(new User("user2","USER TWO"));
        models.put("totalRecords", users.size());
        models.put("users", users);
    }

}
