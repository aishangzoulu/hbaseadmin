package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDataDao;
import cn.edu.muc.ilab.hbaseadmin.service.HTableDataService;
import cn.edu.muc.ilab.hbaseadmin.utils.RowMapperResultsExtractor;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DBW on 2017/4/10.
 *
 */

@Service
public class HTableDataServiceImpl implements HTableDataService {

    @Autowired
    private HTableDataDao hTableDataDao;



    public void put(String tableName, String rowName, String familyName, String qualifier, byte[] value) {

        hTableDataDao.put(tableName,rowName,familyName,qualifier,value);

    }




    public <T> T get(String tableName, String rowName, String familyName, String qualifier, RowMapper<T> mapper) {

        return hTableDataDao.get(tableName,rowName,familyName,qualifier,mapper);

    }

    public <T> T get(String tableName, String rowName, RowMapper<T> mapper) {
        return get(tableName, rowName, null, null, mapper);
    }

    public <T> T get(String tableName, String rowName, String familyName, RowMapper<T> mapper) {
        return get(tableName, rowName, familyName, null, mapper);
    }


    public <T> T find(String tableName, Scan scan, ResultsExtractor<T> action) {

        return hTableDataDao.find(tableName,scan,action);

    }

    public <T> T find(String tableName, String family, ResultsExtractor<T> action) {

        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes(family));
        return find(tableName,scan,action);

    }

    public <T> T find(String tableName, String family, String qualifier, ResultsExtractor<T> action) {

        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes(family),Bytes.toBytes(qualifier));
        return find(tableName,scan,action);

    }

    public <T> List<T> find(String tableName, String family, RowMapper<T> action) {

        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes(family));

        return find(tableName,scan,action);
    }

    public <T> List<T> find(String tableName, String family, String qualifier, RowMapper<T> action) {

        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes(family),Bytes.toBytes(qualifier));
        return find(tableName,scan,action);

    }

    public <T> List<T> find(String tableName, Scan scan, RowMapper<T> action) {

        return find(tableName, scan,new RowMapperResultsExtractor<T>(action));

    }



    public void delete(String tableName, String rowName, String familyName, String qualifier) {

        hTableDataDao.delete(tableName,rowName,familyName,qualifier);

    }

    public void delete(String tableName, String rowName, String familyName) {
        delete(tableName,rowName,familyName,null);
    }



    public void setAutoFlush(boolean autoFlush) {

        hTableDataDao.setAutoFlush(autoFlush);

    }


}
