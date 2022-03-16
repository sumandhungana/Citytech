package global.citytech.interns.crm.services.users.payloads.dto;

import global.citytech.interns.crm.services.common.DomainInfo;

public class UserInfo implements DomainInfo {
    private String id;
    private String fullname;
    private String userrole;
    private String email;
    private String mobile;

    public UserInfo() {
    }

    public UserInfo(String id, String fullname, String userrole, String email, String mobile) {
        this.id = id;
        this.fullname = fullname;
        this.userrole = userrole;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
