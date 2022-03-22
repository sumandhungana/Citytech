package global.citytech.interns.cms.adminwebjsf.users.models;

public class UserDto implements User{
    private String id;
    private String name;
    private String role;
    private String email;
    private String staffid;
    private String branch;

    @Override
    public String getId(){
        return id;
    };

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole(){return role;}

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String getStaffid(){return staffid;}

    @Override
    public void setStaffid(String staffid) {this.staffid = staffid;}

    @Override
    public String getBranch(){return  branch;}

    @Override
    public void setBranch(String branch) {this.branch = branch;}
}
