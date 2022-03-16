package global.citytech.interns.crm.services.users.entities;

import global.citytech.interns.crm.platform.repositories.Entity;

import java.util.Objects;
/*
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
*/

//@Entity
//@Table(name="users", schema = "shared")
public class UserEntity implements Entity  {
    //@Id
    private String id;
    private String fullname;
    private String userrole;
    private String email;
    private String mobile;


    public UserEntity(){
    }

    public UserEntity(String id, String fullname, String userrole, String email, String mobile) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(getId(), userEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
