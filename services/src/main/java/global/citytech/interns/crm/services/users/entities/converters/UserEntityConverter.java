package global.citytech.interns.crm.services.users.entities.converters;


import global.citytech.interns.crm.services.users.entities.UserEntity;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;

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
        info.setFullname(entity.getFullname());
        info.setUserrole(entity.getUserrole());
        info.setEmail(entity.getEmail());
        info.setMobile(entity.getMobile());
        return info;
    }

    public UserEntity toEntity(UserInfo info){
        if(info == null){
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(info.getId());
        entity.setFullname(info.getFullname());
        entity.setUserrole(info.getUserrole());
        entity.setEmail(info.getEmail());
        entity.setMobile(info.getMobile());
        return entity;
    }

    public List<UserInfo> fromEntity(List<UserEntity> entities){
        if(entities == null || entities.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }
}
