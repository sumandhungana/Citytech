package global.citytech.interns.crm.adminweb.foos.views;

import global.citytech.interns.crm.adminweb.foos.models.Foo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddFooForm implements Foo {

    @NotNull
    @Max(value = 100, message = "The name should not contain more than 100 characters.")
    @Min(value = 2, message = "The name should contain at least 2 characters")
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
