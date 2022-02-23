package global.citytech.interns.crm.platform.repositories.querybuilders;

public enum FilterByValueExpression {
    EQ("=", "equals to"),
    GT(">", "greater than"),
    LT("<", "less than"),
    GTE(">=", "greater than or equals to"),
    LTE("<", "less than or equals to"),
    BETWEEN("BETWEEN", "between a certain range"),
    CONTAINS("LIKE", "search for a pattern"),
    BEGINS_WITH("LIKE", "begins with a pattern"),
    ENDS_WITH("LIKE", "ends with a pattern"),
    NOT_EQ("<>", "not equals to"),
    IN("IN", "to specify multiple possible values for a column");

    private final String operator;
    private final String title;

    FilterByValueExpression(String operator, String title) {
        this.operator = operator;
        this.title = title;
    }

    public String getOperator(){
        return this.operator;
    }
}
