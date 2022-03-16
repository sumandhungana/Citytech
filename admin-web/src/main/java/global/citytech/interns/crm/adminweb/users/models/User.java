package global.citytech.interns.crm.adminweb.users.models;

public class User implements Users {
    private String id;
    private String fullname;
    private String userrole;
    private String email;
    private String mobile;

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getFullname() {
        return fullname;
    }
    @Override
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    @Override
    public String getUserrole() {
        return userrole;
    }
    @Override
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getMobile() {
        return mobile;
    }
    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
