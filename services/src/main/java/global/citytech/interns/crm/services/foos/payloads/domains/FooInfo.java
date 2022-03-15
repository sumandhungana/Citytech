package global.citytech.interns.crm.services.foos.payloads.domains;

import global.citytech.interns.crm.services.common.DomainInfo;

import java.util.List;

public class FooInfo implements DomainInfo {
    private String id;
    private String name;

    private List<FooDetailInfo> details;

    public FooInfo() {
    }

    public FooInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FooDetailInfo> getDetails() {
        return details;
    }

    public void setDetails(List<FooDetailInfo> details) {
        this.details = details;
    }

}
