package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseRequest;

public class GetFooRequest implements UseCaseRequest {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
