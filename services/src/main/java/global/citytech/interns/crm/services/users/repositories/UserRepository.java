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
        System.out.println("ADDED USER " + entity.getFullname() + entity.getUserrole()+ entity.getEmail()+ entity.getMobile());
        this.tempUsers.add(entity);
        return entity;
    }
    public UserEntity findOne(String id){
        return this.tempUsers.stream().filter(i->id.equals(i.getId())).findFirst().orElse(null);
    }
    public UserEntity update(UserEntity entity){
        System.out.println("Updated User " + entity.getFullname()+ entity.getUserrole()+ entity.getEmail()+ entity.getMobile());
        this.tempUsers.remove(new UserEntity(entity.getId(), null, null, null, null));
        this.tempUsers.add(entity);
        return entity;
    }

    private void prepareUsers(){
        if(this.tempUsers == null || this.tempUsers.isEmpty()) {
            this.tempUsers.add(new UserEntity("RU001", "USER1", "Admin", "email@gmail.com", "12345"));
            this.tempUsers.add(new UserEntity("RU002", "USER2", "Admins", "gmail@gmail.com", "123456"));
        }
    }
}
