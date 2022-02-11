package global.citytech.interns.crm.adminendpoints.users.payloads;

import global.citytech.interns.crm.adminendpoints.users.payloads.dto.UserInfo;

public class AddUserRequest extends UserInfo {
    public AddUserRequest() {
    }

    public AddUserRequest(String id, String name, String fullName) {
        super(id, name, fullName);
    }
}
