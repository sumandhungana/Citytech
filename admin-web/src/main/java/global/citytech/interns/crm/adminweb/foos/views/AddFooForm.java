package global.citytech.interns.crm.adminweb.foos.views;

import global.citytech.interns.crm.adminweb.foos.models.Foo;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;

import java.io.Serializable;

public class AddFooForm implements Foo, Serializable {

    @NotNull
    //@Max(value = 100, message = "The name should not contain more than 100 characters.")
    //@Min(value = 2, message = "The name should contain at least 2 characters")
    //@Size(max=100, min=2)
    @FormParam("name")
    @MvcBinding
    private String name;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
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
