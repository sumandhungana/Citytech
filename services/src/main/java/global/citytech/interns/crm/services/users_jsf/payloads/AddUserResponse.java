package global.citytech.interns.crm.services.users_jsf.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;

public class AddUserResponse implements UseCaseResponse {
    private String id;

    public AddUserResponse() {
    }

    public AddUserResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
