package cn.edu.muc.ilab.hbaseadmin.dao;

import org.apache.hadoop.hbase.client.Scan;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;

/**
 * Created by DBW on 2017/4/9.
 * HBase数据操作Dao接口
 */
public interface HTableDataDao {

    void put(String tableName, final String rowName, final String familyName, final String qualifier, final byte[] value);

    <T> T get(String tableName, final String rowName, final String familyName, final String qualifier, final RowMapper<T> mapper);

    <T> T find(String tableName, final Scan scan, final ResultsExtractor<T> action);

    void delete(String tableName, final String rowName, final String familyName, final String qualifier);

    void setAutoFlush(boolean autoFlush);

}
