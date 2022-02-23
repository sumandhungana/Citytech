package global.citytech.interns.crm.adminweb.foos.converters;

import global.citytech.interns.crm.adminweb.config.PayloadConverter;
import global.citytech.interns.crm.adminweb.foos.models.Foo;
import global.citytech.interns.crm.adminweb.foos.models.FooDto;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FooPayloadConverter implements PayloadConverter<Foo, FooInfo> {

    @Override
    public FooInfo toRequest(Foo request) {
        if(request == null){
            return null;
        }
        FooInfo domain = new FooInfo();
        domain.setId(request.getId());
        domain.setName(request.getName());
        return domain;
    }

    @Override
    public Foo toResponse(FooInfo response) {
        if(response == null){
            return  null;
        }
        FooDto payload = new FooDto();
        payload.setId(response.getId());
        payload.setName(response.getName());
        return payload;
    }

    @Override
    public List<Foo> toResponseList(List<FooInfo> responseList) {
        if (responseList == null || responseList.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return responseList.stream().map(item-> this.toResponse(item)).collect(Collectors.toList());
    }
}
