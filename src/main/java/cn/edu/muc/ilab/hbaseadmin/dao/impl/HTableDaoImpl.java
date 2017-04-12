package cn.edu.muc.ilab.hbaseadmin.dao.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDao;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.ipc.CoprocessorRpcChannel;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos;
import org.apache.hadoop.hbase.quotas.QuotaFilter;
import org.apache.hadoop.hbase.quotas.QuotaRetriever;
import org.apache.hadoop.hbase.quotas.QuotaSettings;
import org.apache.hadoop.hbase.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 2017/3/25.
 *
 */

@Repository
public class HTableDaoImpl implements HTableDao {


    @Autowired
    private HBaseAdmin hBaseAdmin;

    public boolean tableExists(TableName tableName) {
        boolean result = false;
        try {
            result = hBaseAdmin.tableExists(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean tableExists(String tableName) {
        boolean result = false;
        try {
            result = hBaseAdmin.tableExists(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public HTableDescriptor[] listTables() {
        HTableDescriptor[] hTableDescriptors = null;
        try {
            hTableDescriptors = hBaseAdmin.listTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }

    public HTableDescriptor[] listTables(Pattern pattern) {
        HTableDescriptor[] hTableDescriptors = null;
        try {
            hTableDescriptors = hBaseAdmin.listTables(pattern);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }

    public HTableDescriptor[] listTables(String regex) {
        HTableDescriptor[] hTableDescriptors = null;
        try {
            hTableDescriptors = hBaseAdmin.listTables(regex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hTableDescriptors;
    }


    @Override
    public void createTables(String tableName, String[] columnFamilies) {

        HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));

        try {

            for (String columnFamily : columnFamilies) {

                HColumnDescriptor columnDescriptor = new HColumnDescriptor(columnFamily);

                descriptor.addFamily(columnDescriptor);
            }

            hBaseAdmin.createTable(descriptor);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void createTableAsync(String tableName, String[] columnFamilies, byte[][] splitKeys) {

        HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));

        try {

            for (String columnFamily : columnFamilies) {

                HColumnDescriptor columnDescriptor = new HColumnDescriptor(columnFamily);

                descriptor.addFamily(columnDescriptor);

            }

            hBaseAdmin.createTableAsync(descriptor, splitKeys);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteTables(String[] tableNameList) {
        try {
            for (String tableName : tableNameList) {

                if (hBaseAdmin.isTableEnabled(tableName)){

                    hBaseAdmin.disableTable(tableName);

                }

                hBaseAdmin.deleteTable(tableName);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public TableName[] listTableNames(Pattern pattern, boolean includeSysTables) {

        TableName[] tableNames = null;

        try {

            tableNames =  hBaseAdmin.listTableNames(pattern,includeSysTables);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableNames;

    }

    @Override
    public void enableTable(TableName tableName) {

        try {

            hBaseAdmin.enableTable(tableName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void enableTableAsync(TableName tableName) {

        try {

            hBaseAdmin.enableTableAsync(tableName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void disableTable(TableName tableName) {

        try {

            hBaseAdmin.disableTable(tableName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void disableTableAsync(TableName tableName) {

        try {

            hBaseAdmin.disableTableAsync(tableName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public HTableDescriptor getTableDescriptor(TableName tableName) {

        HTableDescriptor result  = null;

        try {
            result = hBaseAdmin.getTableDescriptor(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isTableEnabled(TableName tableName) {

        boolean result = false;

        try {
            result =  hBaseAdmin.isTableEnabled(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isTableDisabled(TableName tableName) {
        boolean result = false;

        try {
            result =  hBaseAdmin.isTableDisabled(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isTableAvailable(TableName tableName) {
        boolean result = false;

        try {
            result =  hBaseAdmin.isTableAvailable(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Pair<Integer, Integer> getAlterStatus(TableName tableName) {

        Pair<Integer, Integer> result = null;

        try {
            result = hBaseAdmin.getAlterStatus(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void addColumn(TableName tableName, HColumnDescriptor column) {

        try {

            hBaseAdmin.addColumn(tableName,column);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteColumn(TableName tableName, byte[] columnName) {

        try {

            hBaseAdmin.deleteColumn(tableName,columnName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modifyColumn(TableName tableName, HColumnDescriptor descriptor) {

        try {
            hBaseAdmin.modifyColumn(tableName,descriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void closeRegion(byte[] regionName, String serverName) {

        try {
            hBaseAdmin.closeRegion(regionName,serverName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void closeRegion(ServerName sn, HRegionInfo hri) {

        try {
            hBaseAdmin.closeRegion(sn,hri);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean closeRegionWithEncodedRegionName(String encodedRegionName, String serverName) {

        boolean result = false;

        try {
           result =  hBaseAdmin.closeRegionWithEncodedRegionName(encodedRegionName,serverName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void truncateTable(TableName tableName, boolean preserveSplits) {

        try {

            hBaseAdmin.truncateTable(tableName,preserveSplits);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void flushRegion(byte[] regionName) {

        try {
            hBaseAdmin.flushRegion(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void flush(TableName tableName) {

        try {
            hBaseAdmin.flush(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void compact(TableName tableName) {

        try {
            hBaseAdmin.compact(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void compact(TableName tableName, byte[] columnFamily) {

        try {
            hBaseAdmin.compact(tableName,columnFamily);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void compactRegion(byte[] regionName) {

        try {
            hBaseAdmin.compactRegion(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void compactRegion(byte[] regionName, byte[] columnFamily) {

        try {
            hBaseAdmin.compactRegion(regionName,columnFamily);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void compactRegionServer(ServerName sn, boolean major) {

        try {
            hBaseAdmin.compactRegionServer(sn,major);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void majorCompact(TableName tableName) {

        try {
            hBaseAdmin.majorCompact(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void majorCompact(TableName tableName, byte[] columnFamily) {

        try {
            hBaseAdmin.majorCompact(tableName,columnFamily);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void majorCompactRegion(byte[] regionName) {

        try {
            hBaseAdmin.majorCompactRegion(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void majorCompactRegion(byte[] regionName, byte[] columnFamily) {

        try {
            hBaseAdmin.majorCompactRegion(regionName,columnFamily);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void split(TableName tableName, byte[] splitPoint) {

        try {
            hBaseAdmin.split(tableName,splitPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void splitRegion(byte[] regionName, byte[] splitPoint) {

        try {
            hBaseAdmin.splitRegion(regionName,splitPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modifyTable(TableName tableName, HTableDescriptor htd) {

        try {
            hBaseAdmin.modifyTable(tableName,htd);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void snapshot(String snapshotName, TableName tableName, HBaseProtos.SnapshotDescription.Type type) {

        try {
            hBaseAdmin.snapshot(snapshotName,tableName,type);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void snapshot(HBaseProtos.SnapshotDescription snapshot) {

        try {
            hBaseAdmin.snapshot(snapshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void restoreSnapshot(String snapshotName, boolean takeFailSafeSnapshot) {

        try {
            hBaseAdmin.restoreSnapshot(snapshotName,takeFailSafeSnapshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cloneSnapshot(String snapshotName, TableName tableName) {

        try {
            hBaseAdmin.cloneSnapshot(snapshotName,tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<HBaseProtos.SnapshotDescription> listSnapshots() {

        List<HBaseProtos.SnapshotDescription> result = null;

        try {
            result = hBaseAdmin.listSnapshots();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<HBaseProtos.SnapshotDescription> listSnapshots(Pattern pattern) {

        List<HBaseProtos.SnapshotDescription> result = null;

        try {
            result = hBaseAdmin.listSnapshots(pattern);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public void deleteSnapshot(String snapshotName) {

        try {
            hBaseAdmin.deleteSnapshot(snapshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteSnapshots(Pattern pattern) {

        try {
            hBaseAdmin.deleteSnapshots(pattern);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setQuota(QuotaSettings quota) {

        try {
            hBaseAdmin.setQuota(quota);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public QuotaRetriever getQuotaRetriever(QuotaFilter filter) {

        QuotaRetriever result = null;

        try {
            result = hBaseAdmin.getQuotaRetriever(filter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public CoprocessorRpcChannel coprocessorService() {

        CoprocessorRpcChannel result ;

        result =  hBaseAdmin.coprocessorService();

        return result;
    }

    @Override
    public CoprocessorRpcChannel coprocessorService(ServerName sn) {

        CoprocessorRpcChannel result ;

        result =  hBaseAdmin.coprocessorService(sn);

        return result;

    }

    @Override
    public void updateConfiguration(ServerName server) {

        try {
            hBaseAdmin.updateConfiguration(server);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateConfiguration() {

        try {
            hBaseAdmin.updateConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getMasterInfoPort() {

        int result = -1;

        try {
            result = hBaseAdmin.getMasterInfoPort();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public long getLastMajorCompactionTimestamp(TableName tableName) {

        long result = -1;

        try {
            result = hBaseAdmin.getLastMajorCompactionTimestamp(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public long getLastMajorCompactionTimestampForRegion(byte[] regionName) {

        long result = -1;

        try {
            result = hBaseAdmin.getLastMajorCompactionTimestampForRegion(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int getOperationTimeout() {

        return hBaseAdmin.getOperationTimeout();

    }

    @Override
    public void abort(String why, Throwable e) {

        hBaseAdmin.abort(why,e);

    }

    @Override
    public boolean isAborted() {
        return hBaseAdmin.isAborted();
    }


    @Override
    public List<HRegionInfo> getOnlineRegions(ServerName sn) {

        List<HRegionInfo> result = null;

        try {
            result = hBaseAdmin.getOnlineRegions(sn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void move(byte[] encodedRegionName, byte[] destServerName) {

        try {
            hBaseAdmin.move(encodedRegionName,destServerName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void assign(byte[] regionName) {

        try {
            hBaseAdmin.assign(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void unassign(byte[] regionName, boolean force) {

        try {
            hBaseAdmin.unassign(regionName,force);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void offline(byte[] regionName) {

        try {
            hBaseAdmin.offline(regionName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean setBalancerRunning(boolean on, boolean synchronous) {

        boolean result = false;

        try {
            result = hBaseAdmin.setBalancerRunning(on,synchronous);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean balancer() {

        boolean result = false;

        try {
            result = hBaseAdmin.balancer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isBalancerEnabled() {

        boolean result = false;

        try {
            result = hBaseAdmin.isBalancerEnabled();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean enableCatalogJanitor(boolean enable) {

        boolean result = false;

        try {
            result  = hBaseAdmin.enableCatalogJanitor(enable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int runCatalogScan() {

        int  result = -1;

        try {
            result = hBaseAdmin.runCatalogScan();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isCatalogJanitorEnabled() {

        boolean result = false;

        try {
            result = hBaseAdmin.isCatalogJanitorEnabled();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void mergeRegions(byte[] encodedNameOfRegionA, byte[] encodedNameOfRegionB, boolean forcible) {

        try {
            hBaseAdmin.mergeRegions(encodedNameOfRegionA,encodedNameOfRegionB,forcible);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
