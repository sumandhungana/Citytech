package global.citytech.interns.crm.services.users.entities;
/*
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
*/

//@Entity
//@Table(name="users", schema = "shared")
public class UserEntity {
    //@Id
    private String id;
    private String name;
    //@Column(name ="full_name")
    private String fullName;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String fullName) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
