package cn.edu.muc.ilab.hbaseadmin.service;

import org.apache.hadoop.hbase.client.Scan;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;

import java.util.List;

/**
 * Created by DBW on 2017/4/9.
 * 提供HBase数据的查询、插入、更新、删除服务
 */
public interface HTableDataService {

    void put(String tableName, final String rowName, final String familyName, final String qualifier, final byte[] value);

    <T> T get(String tableName, final String rowName, final String familyName, final String qualifier, final RowMapper<T> mapper);
    <T> T get(String tableName, String rowName, final RowMapper<T> mapper);
    <T> T get(String tableName, String rowName, String familyName, final RowMapper<T> mapper);


    <T> T find(String tableName, final Scan scan, final ResultsExtractor<T> action);
    <T> T find(String tableName, String family, final ResultsExtractor<T> action);
    <T> T find(String tableName, String family, String qualifier, final ResultsExtractor<T> action);
    <T> List<T> find(String tableName, String family, final RowMapper<T> action);
    <T> List<T> find(String tableName, String family, String qualifier, final RowMapper<T> action);
    <T> List<T> find(String tableName, final Scan scan, final RowMapper<T> action);


    void delete(String tableName, final String rowName, final String familyName, final String qualifier);
    void delete(String tableName, final String rowName, final String familyName);

    void setAutoFlush(boolean autoFlush);


}
