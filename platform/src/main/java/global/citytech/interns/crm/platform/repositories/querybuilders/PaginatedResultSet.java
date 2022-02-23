package global.citytech.interns.crm.platform.repositories.querybuilders;

import java.util.List;

public class PaginatedResultSet {
    private final List list;
    private final int totalRecords;
    private final int pageSize;

    public PaginatedResultSet(List list, int totalRecords, int pageSize) {
        this.list = list;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }
}
