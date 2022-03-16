package global.citytech.interns.crm.services.users.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseRequest;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;

public class EditUserRequest extends UserInfo implements UseCaseRequest {
    public EditUserRequest() {
    }
    public EditUserRequest(String id, String fullname, String userrole, String email, String mobile){
        super(id, fullname, userrole, email, mobile);
    }

}
