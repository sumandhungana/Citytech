package global.citytech.interns.crm.services.foos.entities.api;

import global.citytech.interns.crm.platform.repositories.Entity;

public interface FooDetailEntity extends Entity {
    String getAlias();

    void setAlias(String alias);
}
