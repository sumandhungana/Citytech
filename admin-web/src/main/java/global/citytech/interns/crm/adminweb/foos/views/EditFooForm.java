package global.citytech.interns.crm.adminweb.foos.views;

import global.citytech.interns.crm.adminweb.foos.models.Foo;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.FormParam;

import java.io.Serializable;

public class EditFooForm implements Foo, Serializable {

    @NotNull
    @FormParam("id")
    private String id;

    @NotNull
    //@Max(value = 100, message = "The name should not contain more than 100 characters.")
    //@Min(value = 2, message = "The name should contain at least 2 characters")
    @FormParam("name")
    @MvcBinding
    private String name;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
