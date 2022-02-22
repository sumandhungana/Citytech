package global.citytech.interns.crm.services.users.payloads;

import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;

import java.util.List;

public record GetAllUsersResponse(List<UserInfo> list) {

}
