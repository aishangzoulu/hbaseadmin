package cn.edu.muc.ilab.hbaseadmin.dao.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDataDao;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by DBW on 2017/4/9.
 * HBase数据操作实现类
 */

@Repository
public class HTableDataDaoImpl implements HTableDataDao{

    @Autowired
    private HbaseTemplate hBaseTemplate;


    @Override
    public void put(String tableName, String rowName, String familyName, String qualifier, byte[] value) {

        hBaseTemplate.put(tableName,rowName,familyName,qualifier,value);

    }

    @Override
    public <T> T get(String tableName, String rowName, String familyName, String qualifier, RowMapper<T> mapper) {

        return hBaseTemplate.get(tableName,rowName,familyName,qualifier,mapper);

    }

    @Override
    public <T> T find(String tableName, Scan scan, ResultsExtractor<T> action) {

        return hBaseTemplate.find(tableName,scan,action);

    }

    @Override
    public void delete(String tableName, String rowName, String familyName, String qualifier) {

        hBaseTemplate.delete(tableName,rowName,familyName,qualifier);

    }

    @Override
    public void setAutoFlush(boolean autoFlush) {

        hBaseTemplate.setAutoFlush(autoFlush);

    }
}
