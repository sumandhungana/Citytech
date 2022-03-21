package global.citytech.interns.crm.services.foos.entities.api;

import global.citytech.interns.crm.platform.repositories.Entity;

public interface FooEntity extends Entity {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getDetails();

    void setDetails(String details);



}
