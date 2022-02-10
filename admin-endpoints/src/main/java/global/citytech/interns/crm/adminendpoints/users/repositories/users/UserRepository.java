package global.citytech.interns.crm.adminendpoints.users.repositories.users;


import global.citytech.interns.crm.adminendpoints.users.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<UserEntity> findAll(){
        return this.prepareUsers();
    }

    private List<UserEntity> prepareUsers(){
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity("RU001", "USER1", "USER ONE"));
        users.add(new UserEntity("RU002", "USER2", "USER TWO"));
        users.add(new UserEntity("RU003", "USER3", "USER THREE"));
        users.add(new UserEntity("RU004", "USER4", "USER FOUR"));
        users.add(new UserEntity("RU005", "USER5", "USER FIVE"));
        return users;
    }
}
