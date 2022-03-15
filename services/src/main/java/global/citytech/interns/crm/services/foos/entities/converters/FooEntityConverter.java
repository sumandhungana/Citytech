package global.citytech.interns.crm.services.foos.entities.converters;

import global.citytech.interns.crm.platform.utils.JsonUtils;
import global.citytech.interns.crm.services.foos.entities.FooDetailJPAEntity;
import global.citytech.interns.crm.services.foos.entities.FooJPAEntity;
import global.citytech.interns.crm.services.foos.entities.api.FooDetailEntity;
import global.citytech.interns.crm.services.foos.entities.api.FooEntity;
import global.citytech.interns.crm.services.foos.payloads.domains.FooDetailInfo;
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
        System.out.println("Adding items ... " + entity.getDetails() );
        if(entity.getDetails() != null && !entity.getDetails().isBlank()){
            List<FooDetailJPAEntity> fooDetailEntities = JsonUtils.fromJsonToList(entity.getDetails(), FooDetailJPAEntity.class);
            System.out.println("Adding items ... "+fooDetailEntities.size());
            info.setDetails(fooDetailEntities.stream().map(i-> this.toDetail(i)).collect(Collectors.toList()));
        }
        return info;
    }

    public FooEntity toEntity(FooInfo info){
        if(info == null){
            return null;
        }
        FooEntity entity = new FooJPAEntity();
        entity.setId(info.getId());
        entity.setName(info.getName());
        if(info.getDetails() != null && !info.getDetails().isEmpty()){
            entity.setDetails(JsonUtils.toJsonObj(info.getDetails()));
        }
        return entity;
    }

    public List<FooInfo> fromEntity(List<FooEntity> entities){
        if(entities == null || entities.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return entities.stream().map(item-> this.fromEntity(item)).collect(Collectors.toList());
    }

    private FooDetailEntity toDetail(FooDetailInfo detailInfo){
        FooDetailEntity detail = new FooDetailJPAEntity();
        detail.setAlias(detailInfo.getAlias());
        return detail;
    }

    private FooDetailInfo toDetail(FooDetailEntity detailEntity){
        FooDetailInfo detailInfo = new FooDetailInfo();
        detailInfo.setAlias(detailEntity.getAlias());
        return detailInfo;
    }
}
