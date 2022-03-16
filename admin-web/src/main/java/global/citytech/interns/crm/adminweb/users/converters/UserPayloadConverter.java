package global.citytech.interns.crm.adminweb.users.converters;

import global.citytech.interns.crm.adminweb.config.PayloadConverter;
import global.citytech.interns.crm.adminweb.users.models.Users;
import global.citytech.interns.crm.adminweb.users.models.User;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class UserPayloadConverter implements PayloadConverter<Users, UserInfo> {
    @Override
    public UserInfo toRequest(Users request) {
        if(request == null){
            return null;
        }
        UserInfo domain = new UserInfo();
        domain.setId(request.getId());
        domain.setFullname(request.getFullname());
        domain.setUserrole(request.getUserrole());
        domain.setEmail(request.getEmail());
        domain.setMobile(request.getMobile());
        return domain;
    }

    @Override
    public Users toResponse(UserInfo response) {
        if(response == null){
            return  null;
        }
        User payload = new User();
        payload.setId(response.getId());
        payload.setFullname(response.getFullname());
        payload.setUserrole(response.getUserrole());
        payload.setEmail(response.getEmail());
        payload.setMobile(response.getMobile());
        return payload;
    }

    @Override
    public List<Users> toResponseList(List<UserInfo> responseList) {
        if (responseList == null || responseList.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return responseList.stream().map(item-> this.toResponse(item)).collect(Collectors.toList());
    }
}

