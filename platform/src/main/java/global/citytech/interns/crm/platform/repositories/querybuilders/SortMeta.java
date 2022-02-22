package global.citytech.interns.crm.platform.repositories.querybuilders;

public record SortMeta(String column, SortOrder sortOrder) {
    public SortMeta() {
        this("");
    }

    public SortMeta(String column) {
        this(column, SortOrder.ASC);
    }

    public enum SortOrder {
        ASC, DESC;
    }
}


