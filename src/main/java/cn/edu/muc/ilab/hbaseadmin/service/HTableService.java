package cn.edu.muc.ilab.hbaseadmin.service;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;

import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/29.
 *
 */
public interface HTableService {
    boolean tableExists(TableName tableName);
    boolean tableExists(String tableName);
    HTableDescriptor[] listTables();
    HTableDescriptor[] listTables(Pattern pattern);
    HTableDescriptor[] listTables(String regex);

    void createTable(@NotNull String tableName,@NotNull String columnFamily);
    void createTable(@NotNull String tableName,@NotNull String[] columnFamilies);
    void createTableAsync(@NotNull String tableName,@NotNull String columnFamily,byte[][] splitKeys);
    void createTableAsync(@NotNull String tableName,@NotNull String[] columnFamilies,@NotNull byte[][]splitKeys);

    void deleteTable(String tableName);
    void deleteTables(String[] tableNameList);

}
