package global.citytech.interns.crm.services.users_jsf.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseRequest;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;

public class AddUserRequest extends UserInfo implements UseCaseRequest {
    public AddUserRequest() {
    }

    public AddUserRequest(String id, String name, String role, String email, String staffid, String branch) {
        super(id, name, role, email, staffid, branch);
    }
}
