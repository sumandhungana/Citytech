package global.citytech.interns.crm.services.users_jsf.entities;

import global.citytech.interns.crm.services.users_jsf.entities.api.UserDetailEntity;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user_jsf")
public class UserJPAEntity implements UserEntity {
    @Id
    private String id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="role", length = 100)
    private String role;

    @Column(name="email", length = 100)
    private String email;

    @Column(name="staffid", length = 100)
    private String staffid;

    @Column(name="branch", length = 100)
    private String branch;

    @Override
    public String getId() {
        return id;
    }

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
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
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
    public String getStaffid() {
        return staffid;
    }

    @Override
    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    @Override
    public String getBranch() {
        return branch;
    }

    @Override
    public void setBranch(String branch) {
        this.branch = branch;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJPAEntity userEntity = (UserJPAEntity) o;
        return Objects.equals(getId(), userEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
