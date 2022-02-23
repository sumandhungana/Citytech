package global.citytech.interns.crm.services.users.repositories;


import global.citytech.interns.crm.services.users.entities.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository {

    List<UserEntity> tempUsers = new ArrayList<>();

    public UserRepository() {
        this.prepareUsers();
    }

    public List<UserEntity> findAll(){
        return this.tempUsers;
    }

    public UserEntity add(UserEntity entity){
        System.out.println("ADDED USER " + entity.getFullName());
        this.tempUsers.add(entity);
        return entity;
    }

    private void prepareUsers(){
        if(this.tempUsers == null || this.tempUsers.isEmpty()) {
            this.tempUsers.add(new UserEntity("RU001", "USER1", "USER ONE"));
            this.tempUsers.add(new UserEntity("RU002", "USER2", "USER TWO"));
            this.tempUsers.add(new UserEntity("RU003", "USER3", "USER THREE"));
            this.tempUsers.add(new UserEntity("RU004", "USER4", "USER FOUR"));
            this.tempUsers.add(new UserEntity("RU005", "USER5", "USER FIVE"));
        }
    }
}
