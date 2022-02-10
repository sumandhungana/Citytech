package global.citytech.interns.crm.adminendpoints.users.payloads;

import global.citytech.interns.crm.adminendpoints.users.payloads.dto.UserInfo;

import java.util.List;

public record GetAllUsersResponse(List<UserInfo> list) {

}
