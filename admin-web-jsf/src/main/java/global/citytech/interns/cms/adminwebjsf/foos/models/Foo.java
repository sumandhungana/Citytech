package global.citytech.interns.cms.adminwebjsf.foos.models;

import global.citytech.interns.cms.adminwebjsf.config.Payload;

import java.util.List;

public interface Foo extends Payload{

    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public List<FooDetail> getDetails();

    public void setDetails(List<FooDetail> details);

    public void addDetail(FooDetail detail);

}
