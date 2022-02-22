package global.citytech.interns.crm.adminweb.config;

import global.citytech.interns.crm.services.common.DomainInfo;

import java.util.List;

public interface PayloadConverter<A extends Payload, B extends DomainInfo>{
    public B toRequest(A request);

    public A toResponse(B response);

    public List<A> toResponseList(List<B> responseList);
}
