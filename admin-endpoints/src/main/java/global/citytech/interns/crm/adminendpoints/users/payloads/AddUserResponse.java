package global.citytech.interns.crm.adminendpoints.users.payloads;

public class AddUserResponse {
    private String id;

    public AddUserResponse() {
    }

    public AddUserResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
