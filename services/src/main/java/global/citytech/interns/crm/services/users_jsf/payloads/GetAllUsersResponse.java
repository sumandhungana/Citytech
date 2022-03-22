package global.citytech.interns.crm.services.users_jsf.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;

import java.util.List;

public record GetAllUsersResponse(List<UserInfo> list) implements UseCaseResponse {

}