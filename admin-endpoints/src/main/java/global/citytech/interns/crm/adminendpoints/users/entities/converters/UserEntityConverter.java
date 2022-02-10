package global.citytech.interns.crm.adminendpoints.users.entities.converters;

import global.citytech.interns.crm.adminendpoints.users.entities.UserEntity;
import global.citytech.interns.crm.adminendpoints.users.payloads.dto.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

public class UserEntityConverter {
    public UserInfo fromEntity(UserEntity entity){
        UserInfo info = new UserInfo();
        info.setId(entity.getId());
        info.setName(entity.getName());
        info.setFullName(entity.getFullName());
        return info;
    }

    public UserEntity toEntity(UserInfo info){
        UserEntity entity = new UserEntity();
        entity.setId(info.getId());
        entity.setName(info.getName());
        entity.setFullName(info.getFullName());
        return entity;
    }

    public List<UserInfo> fromEntity(List<UserEntity> entities){
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }
}
