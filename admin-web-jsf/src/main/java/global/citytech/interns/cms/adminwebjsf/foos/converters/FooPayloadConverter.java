package global.citytech.interns.cms.adminwebjsf.foos.converters;

import global.citytech.interns.cms.adminwebjsf.config.PayloadConverter;
import global.citytech.interns.cms.adminwebjsf.foos.models.Foo;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetail;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetailDto;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDto;
import global.citytech.interns.crm.services.foos.payloads.domains.FooDetailInfo;
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
        if(request.getDetails() != null && !request.getDetails().isEmpty()){
            domain.setDetails(request.getDetails().stream().map(i-> this.toDetail(i)).collect(Collectors.toList()));
        }
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
        if(response.getDetails() != null && !response.getDetails().isEmpty()){
            payload.setDetails(response.getDetails().stream().map(i-> this.toDetail(i)).collect(Collectors.toList()));
        }
        return payload;
    }

    @Override
    public List<Foo> toResponseList(List<FooInfo> responseList) {
        if (responseList == null || responseList.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return responseList.stream().map(item-> this.toResponse(item)).collect(Collectors.toList());
    }

    private FooDetail toDetail(FooDetailInfo detailInfo){
        FooDetail detail = new FooDetailDto();
        detail.setAlias(detailInfo.getAlias());
        return detail;
    }

    private FooDetailInfo toDetail(FooDetail detail){
        FooDetailInfo detailInfo = new FooDetailInfo();
        detailInfo.setAlias(detail.getAlias());
        return detailInfo;
    }

}
