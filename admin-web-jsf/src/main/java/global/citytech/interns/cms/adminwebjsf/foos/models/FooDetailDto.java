package global.citytech.interns.cms.adminwebjsf.foos.models;

public class FooDetailDto implements FooDetail{
    private String alias;

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
