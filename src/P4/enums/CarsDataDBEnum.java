package P4.enums;

public enum CarsDataDBEnum {
    TYPE("TYPE"),
    NAME("NAME"),
    PRICE("PRICE"),
    CONSUMPTION("CONSUMPTION"),
    ID("ID");

    private String columnName;

    CarsDataDBEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName(){
        return columnName;
    }

}