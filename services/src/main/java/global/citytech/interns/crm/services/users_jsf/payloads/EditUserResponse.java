package global.citytech.interns.crm.services.users_jsf.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;

public class EditUserResponse implements UseCaseResponse {
    private String id;
    public EditUserResponse(){}

    public EditUserResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
