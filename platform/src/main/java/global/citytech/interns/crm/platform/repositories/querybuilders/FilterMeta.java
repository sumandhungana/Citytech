package global.citytech.interns.crm.platform.repositories.querybuilders;

public record FilterMeta(String field, FilterByValueExpression valueExpression, Object filterValue) {
    public FilterMeta(String field, Object filterValue){
        this(field, FilterByValueExpression.EQ, filterValue);
    }
}
