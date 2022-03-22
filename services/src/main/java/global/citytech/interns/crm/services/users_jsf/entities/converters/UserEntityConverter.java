package global.citytech.interns.crm.services.users_jsf.entities.converters;

import global.citytech.interns.crm.platform.utils.JsonUtils;
import global.citytech.interns.crm.services.users_jsf.entities.UserDetailJPAEntity;
import global.citytech.interns.crm.services.users_jsf.entities.UserJPAEntity;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserDetailEntity;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserDetailInfo;
import global.citytech.interns.crm.services.users_jsf.payloads.dto.UserInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserEntityConverter {
    public UserInfo fromEntity(UserEntity entity){
        if(entity == null){
            return null;
        }
        UserInfo info = new UserInfo();
        info.setId(entity.getId());
        info.setName(entity.getName());
        info.setRole(entity.getRole());
        info.setEmail(entity.getEmail());
        info.setStaffid(entity.getStaffid());
        info.setBranch(entity.getBranch());
        System.out.println("GET EMAIL... " + entity.getEmail());
        return info;
    }

    public UserEntity toEntity(UserInfo info){
        if(info == null){
            return null;
        }
        UserEntity entity = new UserJPAEntity();
        entity.setId(info.getId());
        entity.setName(info.getName());
        entity.setRole(info.getRole());
        entity.setEmail(info.getEmail());
        entity.setStaffid(info.getStaffid());
        entity.setBranch(info.getBranch());
        return entity;
    }

    public List<UserInfo> fromEntity(List<UserEntity> entities){
        if(entities == null || entities.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }

}
