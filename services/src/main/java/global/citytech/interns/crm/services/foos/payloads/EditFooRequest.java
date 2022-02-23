package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseRequest;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

public class EditFooRequest extends FooInfo implements UseCaseRequest {
    public EditFooRequest() {
    }

    public EditFooRequest(String id, String name) {
        super(id, name);
    }
}
