package global.citytech.interns.crm.services.foos.entities;
/*
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
*/

import global.citytech.interns.crm.platform.repositories.Entity;

import java.util.Objects;

//@Entity
//@Table(name="foos")
public class FooEntity implements Entity {
    //@Id
    private String id;
    private String name;

    public FooEntity() {
    }

    public FooEntity(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FooEntity fooEntity = (FooEntity) o;
        return Objects.equals(getId(), fooEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
