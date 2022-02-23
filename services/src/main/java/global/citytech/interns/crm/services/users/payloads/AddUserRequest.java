package global.citytech.interns.crm.services.users.payloads;


import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;

public class AddUserRequest extends UserInfo {
    public AddUserRequest() {
    }

    public AddUserRequest(String id, String name, String fullName) {
        super(id, name, fullName);
    }
}
