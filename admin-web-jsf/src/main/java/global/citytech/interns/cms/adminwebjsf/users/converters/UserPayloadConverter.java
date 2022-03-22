package global.citytech.interns.cms.adminwebjsf.users.converters;

import global.citytech.interns.cms.adminwebjsf.config.PayloadConverter;
import global.citytech.interns.cms.adminwebjsf.users.models.User;
import global.citytech.interns.cms.adminwebjsf.users.models.UserDto;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserDetailInfo;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserPayloadConverter implements PayloadConverter<User, UserInfo> {

    @Override
    public UserInfo toRequest(User request) {
        if(request == null){
            return null;
        }
        UserInfo domain = new UserInfo();
        domain.setId(request.getId());
        domain.setName(request.getName());
        domain.setBranch(request.getBranch());
        domain.setStaffid(request.getStaffid());
        domain.setEmail(request.getEmail());
        domain.setRole(request.getRole());
        return domain;
    }

    @Override
    public User toResponse(UserInfo response) {
        if(response == null){
            return  null;
        }
        UserDto payload = new UserDto();
        payload.setId(response.getId());
        payload.setName(response.getName());
        payload.setBranch(response.getBranch());
        payload.setEmail(response.getEmail());
        payload.setStaffid(response.getStaffid());
        payload.setRole(response.getRole());
        return payload;
    }

    @Override
    public List<User> toResponseList(List<UserInfo> responseList) {
        if (responseList == null || responseList.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return responseList.stream().map(item-> this.toResponse(item)).collect(Collectors.toList());
    }



}
