package cn.edu.muc.ilab.hbaseadmin.service;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;

import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/29.
 */
public interface HTableService {
    boolean tableExists(TableName tableName);
    boolean tableExists(String tableName);
    HTableDescriptor[] listTables();
    HTableDescriptor[] listTables(Pattern pattern);
    HTableDescriptor[] listTables(String regex);
}
