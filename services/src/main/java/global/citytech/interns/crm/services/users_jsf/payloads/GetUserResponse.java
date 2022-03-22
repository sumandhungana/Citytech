package global.citytech.interns.crm.services.users_jsf.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;

public class GetUserResponse implements UseCaseResponse {
    private UserInfo userInfo;

    public GetUserResponse() {
    }

    public GetUserResponse(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
