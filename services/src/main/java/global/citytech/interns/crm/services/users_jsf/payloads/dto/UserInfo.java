package global.citytech.interns.crm.services.users_jsf.payloads.dto;

import global.citytech.interns.crm.services.common.DomainInfo;

import java.util.List;

public class UserInfo implements DomainInfo {
    private String id;
    private String name;
    private String role;
    private String email;
    private String staffid;
    private String branch;

    public UserInfo() {
    }
    public UserInfo(String id, String name, String role, String email, String staffid, String branch) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
        this.staffid = staffid;
        this.branch = branch;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


}
