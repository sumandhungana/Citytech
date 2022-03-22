package global.citytech.interns.crm.services.users_jsf.entities.api;

import global.citytech.interns.crm.platform.repositories.Entity;

public interface UserEntity extends Entity {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getRole();

    void setRole(String role);

    String getEmail();

    void setEmail(String email);

    String getStaffid();

    void setStaffid(String staffid);

    String getBranch();

    void setBranch(String branch);

}