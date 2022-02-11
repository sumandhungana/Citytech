package global.citytech.interns.crm.adminweb.users.views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class AddUserForm {
    @NotNull
    @Max(10)
    private String name;
}
