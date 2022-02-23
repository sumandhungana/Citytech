package global.citytech.interns.crm.services.foos.entities.converters;

import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

import java.util.List;
import java.util.stream.Collectors;

public class FooEntityConverter {
    public FooInfo fromEntity(FooEntity entity){
        FooInfo info = new FooInfo();
        info.setId(entity.getId());
        info.setName(entity.getName());
        return info;
    }

    public FooEntity toEntity(FooInfo info){
        FooEntity entity = new FooEntity();
        entity.setId(info.getId());
        entity.setName(info.getName());
        return entity;
    }

    public List<FooInfo> fromEntity(List<FooEntity> entities){
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }
}
