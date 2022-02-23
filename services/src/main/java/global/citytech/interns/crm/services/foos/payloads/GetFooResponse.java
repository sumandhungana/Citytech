package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

public class GetFooResponse implements UseCaseResponse {
    private FooInfo fooInfo;

    public GetFooResponse() {
    }

    public GetFooResponse(FooInfo fooInfo) {
        this.fooInfo = fooInfo;
    }

    public FooInfo getFooInfo() {
        return fooInfo;
    }

    public void setFooInfo(FooInfo fooInfo) {
        this.fooInfo = fooInfo;
    }
}
