package global.citytech.interns.crm.services.foos.entities.converters;

import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FooEntityConverter {
    public FooInfo fromEntity(FooEntity entity){
        if(entity == null){
            return null;
        }
        FooInfo info = new FooInfo();
        info.setId(entity.getId());
        info.setName(entity.getName());
        return info;
    }

    public FooEntity toEntity(FooInfo info){
        if(info == null){
            return null;
        }
        FooEntity entity = new FooEntity();
        entity.setId(info.getId());
        entity.setName(info.getName());
        return entity;
    }

    public List<FooInfo> fromEntity(List<FooEntity> entities){
        if(entities == null || entities.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }
}
