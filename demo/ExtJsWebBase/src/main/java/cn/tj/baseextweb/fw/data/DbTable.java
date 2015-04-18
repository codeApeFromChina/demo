package cn.tj.baseextweb.fw.data;

import java.util.List;

public class DbTable {

    private String tableName;
    private List<DbField> fields;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<DbField> getFields() {
        return fields;
    }

    public void setFields(List<DbField> fields) {
        this.fields = fields;
    }

}
