package cn.edu.muc.ilab.hbaseadmin.dao;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MetaTableAccessor;
import org.apache.hadoop.hbase.TableName;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/25.
 */
public interface HTableDao {
    boolean tableExists(TableName tableName);
    boolean tableExists(String tableName);
    HTableDescriptor[] listTables();
    HTableDescriptor[] listTables(Pattern pattern);
    HTableDescriptor[] listTables(String regex);
}
