package global.citytech.interns.crm.adminendpoints.users.entities;

public class UserEntity {
    private String id;
    private String name;
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
