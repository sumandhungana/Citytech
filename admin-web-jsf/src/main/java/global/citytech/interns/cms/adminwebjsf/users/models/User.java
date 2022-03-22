package global.citytech.interns.cms.adminwebjsf.users.models;

import global.citytech.interns.cms.adminwebjsf.config.Payload;

public interface User extends Payload {
    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public String getRole();

    public void setRole(String role);

    public String getEmail();

    public void setEmail(String email);

    public String getStaffid();

    public void setStaffid(String staffid);

    public String getBranch();

    public void setBranch(String branch);
}
