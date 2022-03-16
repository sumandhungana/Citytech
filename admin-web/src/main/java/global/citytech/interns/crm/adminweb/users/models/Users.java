package global.citytech.interns.crm.adminweb.users.models;

import global.citytech.interns.crm.adminweb.config.Payload;

public interface Users extends Payload {
    public String getId();

    public void setId(String id);

    public String getFullname();

    public void setFullname(String fullname);

    public String getUserrole();

    public void setUserrole(String Userrole);

    public String getEmail();

    public void setEmail(String email);

    public String getMobile();

    public void setMobile(String mobile);

}
