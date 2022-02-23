package global.citytech.interns.crm.services.foos.repositories;

import global.citytech.interns.crm.services.foos.entities.FooEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FooRepository {

    List<FooEntity> tempUsers = new ArrayList<>();

    public FooRepository() {
        this.prepareUsers();
    }

    public List<FooEntity> findAll(){
        return this.tempUsers;
    }

    public FooEntity create(FooEntity entity){
        System.out.println("ADDED Foo " + entity.getName());
        this.tempUsers.add(entity);
        return entity;
    }

    public FooEntity findOne(String id){
        return this.tempUsers.stream().filter(i->id.equals(i.getId())).findFirst().orElse(null);
    }

    public FooEntity update(FooEntity entity){
        System.out.println("Updated Foo " + entity.getName());
        this.tempUsers.remove(new FooEntity(entity.getId(), null));
        this.tempUsers.add(entity);
        return entity;
    }

    private void prepareUsers(){
        if(this.tempUsers == null || this.tempUsers.isEmpty()) {
            this.tempUsers.add(new FooEntity("F001", "FOO1"));
            this.tempUsers.add(new FooEntity("F002", "FOO2"));
            this.tempUsers.add(new FooEntity("F003", "FOO3"));
            this.tempUsers.add(new FooEntity("F004", "FOO4"));
            this.tempUsers.add(new FooEntity("F005", "FOO5"));
        }
    }
}
