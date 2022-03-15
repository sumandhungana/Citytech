package global.citytech.interns.crm.services.foos.entities;

import global.citytech.interns.crm.services.foos.entities.api.FooDetailEntity;

public class FooDetailJPAEntity implements FooDetailEntity {
    private String alias;

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
