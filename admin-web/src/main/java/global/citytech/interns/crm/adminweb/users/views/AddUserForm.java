package global.citytech.interns.crm.adminweb.users.views;

import global.citytech.interns.crm.adminweb.foos.models.Foo;
import global.citytech.interns.crm.adminweb.users.models.User;
import global.citytech.interns.crm.adminweb.users.models.Users;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;

import java.io.Serializable;

public class AddUserForm implements Users, Serializable {

    //@Max(value = 100, message = "The name should not contain more than 100 characters.")
    //@Min(value = 2, message = "The name should contain at least 2 characters")
    //@Size(max=100, min=2)
    @NotNull
    @FormParam("fullname")
    @MvcBinding

    private String fullname;

    @NotNull
    @FormParam("userrole")
    @MvcBinding

    private String userrole;

    @NotNull
    @FormParam("email")
    @MvcBinding

    private String email;

    @NotNull
    @FormParam("mobile")
    @MvcBinding

    private String mobile;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
    }

    @Override
    public String getFullname() {
        return this.fullname;
    }

    @Override
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getUserrole() {
        return this.userrole;
    }

    @Override
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getMobile() {
        return this.mobile;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
