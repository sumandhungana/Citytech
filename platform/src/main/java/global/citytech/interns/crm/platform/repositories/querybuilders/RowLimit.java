package global.citytech.interns.crm.platform.repositories.querybuilders;

public record RowLimit(int offset, int pageSize){
    public RowLimit(){
        this(0,10);
    }

    public RowLimit(int offset){
        this(offset, 10);
    }

}
