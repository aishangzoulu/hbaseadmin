package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDao;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/29.
 *
 */
@Service
public class HTableServiceImpl implements HTableService {

    @Autowired
    private HTableDao hTableDao;

    public boolean tableExists(TableName tableName){
        return hTableDao.tableExists(tableName);
    }
    public boolean tableExists(String tableName){
        return hTableDao.tableExists(tableName);
    }
    public HTableDescriptor[] listTables(){
        return hTableDao.listTables();
    }
    public HTableDescriptor[] listTables(Pattern pattern){
        return hTableDao.listTables(pattern);
    }

    public HTableDescriptor[] listTables(String regex){
        return hTableDao.listTables(regex);
    }

    @Override
    public void createTable(String tableName, String columnFamily) {

        this.createTable(tableName,new String[]{columnFamily});

    }

    @Override
    public void createTable(String tableName, String[] columnFamilies) {

        hTableDao.createTables(tableName,columnFamilies);

    }

    @Override
    public void createTableAsync(String tableName, String columnFamily,byte[][] splitKeys) {

        this.createTableAsync(tableName,new String[]{columnFamily},splitKeys);

    }

    @Override
    public void createTableAsync(String tableName, String[] columnFamilies,byte[][] splitKeys) {

        hTableDao.createTableAsync(tableName,columnFamilies,splitKeys);

    }

    @Override
    public void deleteTable(String tableName) {

        this.deleteTables(new String[]{tableName});

    }

    @Override
    public void deleteTables(String[] tableNameList) {

        hTableDao.deleteTables(tableNameList);

    }


}
