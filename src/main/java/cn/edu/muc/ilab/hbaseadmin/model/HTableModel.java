package cn.edu.muc.ilab.hbaseadmin.model;

/**
 * Created by Raymond on 2017/3/29.
 * Updated by DBW on 2017/4/24
 *
 *用来返回某一个HTable的model类
 *
 */
public class HTableModel {

    private String hTableName;

    private String[] rows;

    private String[] families;

    private String[] qualifiers;

    public HTableModel(String hTableName){

        this.hTableName = hTableName;

    }

    public HTableModel() {

    }
    public String gethTableName() {
        return hTableName;
    }

    public void sethTableName(String hTableName) {
        this.hTableName = hTableName;
    }
    public String[] getRows() {
        return rows;
    }

    public void setRows(String[] rows) {
        this.rows = rows;
    }

    public String[] getFamilies() {
        return families;
    }

    public void setFamilies(String[] families) {
        this.families = families;
    }

    public String[] getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(String[] qualifiers) {
        this.qualifiers = qualifiers;
    }
}
