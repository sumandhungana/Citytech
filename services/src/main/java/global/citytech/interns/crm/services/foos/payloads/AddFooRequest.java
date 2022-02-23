package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseRequest;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

public class AddFooRequest extends FooInfo implements UseCaseRequest {
    public AddFooRequest() {
    }

    public AddFooRequest(String id, String name) {
        super(id, name);
    }
}
