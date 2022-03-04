package global.citytech.interns.crm.services.foos.filters;

import global.citytech.interns.crm.platform.repositories.FilterCriteria;

public class FooFilter implements FilterCriteria {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
