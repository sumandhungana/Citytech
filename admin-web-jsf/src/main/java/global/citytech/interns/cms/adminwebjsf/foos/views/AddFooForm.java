package global.citytech.interns.cms.adminwebjsf.foos.views;

import global.citytech.interns.cms.adminwebjsf.foos.models.Foo;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddFooForm implements Foo, Serializable {

    private String name;

    private List<FooDetail> details;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
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
