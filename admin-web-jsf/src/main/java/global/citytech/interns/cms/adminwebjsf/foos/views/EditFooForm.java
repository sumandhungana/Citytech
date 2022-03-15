package global.citytech.interns.cms.adminwebjsf.foos.views;

import global.citytech.interns.cms.adminwebjsf.foos.models.Foo;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditFooForm implements Foo, Serializable {

    private String id;

    private String name;

    private List<FooDetail> details;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<FooDetail> getDetails() {
        return details;
    }

    @Override
    public void setDetails(List<FooDetail> details) {
        this.details = details;
    }

    @Override
    public void addDetail(FooDetail detail) {
        if(this.details == null){
            this.details = new ArrayList<>();
        }
        this.details.add(detail);
    }
}
