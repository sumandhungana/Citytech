package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;

public class AddFooResponse implements UseCaseResponse {
    private String id;

    public AddFooResponse() {
    }

    public AddFooResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
