package global.citytech.interns.crm.services.foos.entities;

import global.citytech.interns.crm.services.foos.entities.api.FooEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.Objects;

@Entity
@Table(name="foos")
public class FooJPAEntity implements FooEntity {
    @Id
    private String id;

    @Column(name="name", length = 100)
    private String name;

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
        FooJPAEntity fooEntity = (FooJPAEntity) o;
        return Objects.equals(getId(), fooEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
