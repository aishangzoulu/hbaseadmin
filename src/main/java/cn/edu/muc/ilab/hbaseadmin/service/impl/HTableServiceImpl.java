package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDao;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import javafx.scene.control.Tab;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.ipc.CoprocessorRpcChannel;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos;
import org.apache.hadoop.hbase.quotas.QuotaFilter;
import org.apache.hadoop.hbase.quotas.QuotaRetriever;
import org.apache.hadoop.hbase.quotas.QuotaSettings;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void createTable(String tableName, String[] columnFamilies) {

        hTableDao.createTables(tableName,columnFamilies);

    }

    @Override
    public void createTableAsync(String tableName, String columnFamily,byte[][] splitKeys) {

        this.createTableAsync(tableName,new String[]{columnFamily},splitKeys);

    }

    public void createTableAsync(String tableName, String[] columnFamilies,byte[][] splitKeys) {

        hTableDao.createTableAsync(tableName,columnFamilies,splitKeys);

    }

    @Override
    public void deleteTable(String tableName) {

        this.deleteTables(new String[]{tableName});

    }

    public void deleteTables(String[] tableNameList) {

        hTableDao.deleteTables(tableNameList);

    }

    @Override
    public TableName[] listTableNames() {

        return listTableNames((Pattern)null, false);

    }

    public TableName[] listTableNames(Pattern pattern) {

        return listTableNames(pattern, false);

    }

    public TableName[] listTableNames(String regex) {

        return listTableNames(Pattern.compile(regex), false);

    }

    public TableName[] listTableNames(Pattern pattern, boolean includeSysTables) {

        return hTableDao.listTableNames(pattern,includeSysTables);

    }

    public TableName[] listTableNames(String regex, boolean includeSysTables) {

        return listTableNames(Pattern.compile(regex), includeSysTables);
    }

    @Override
    public void enableTable(TableName tableName) {

        hTableDao.enableTable(tableName);

    }

    public void enableTable(byte[] tableName) {

        enableTable(TableName.valueOf(tableName));

    }

    public void enableTable(String tableName) {

        enableTable(TableName.valueOf(tableName));

    }

    @Override
    public void enableTableAsync(TableName tableName) {

        hTableDao.enableTableAsync(tableName);

    }

    public void enableTableAsync(byte[] tableName) {

        enableTableAsync(TableName.valueOf(tableName));

    }

    public void enableTableAsync(String tableName) {

        enableTableAsync(TableName.valueOf(tableName));

    }

    @Override
    public void disableTable(TableName tableName) {

        hTableDao.disableTable(tableName);

    }

    public void disableTable(byte[] tableName) {

        disableTable(TableName.valueOf(tableName));

    }

    public void disableTable(String tableName) {

        disableTable(TableName.valueOf(tableName));

    }

    @Override
    public HTableDescriptor getTableDescriptor(TableName tableName) {

        return hTableDao.getTableDescriptor(tableName);

    }

    public HTableDescriptor getTableDescriptor(byte[] tableName) {

        return getTableDescriptor(TableName.valueOf(tableName));

    }

    @Override
    public void truncateTable(TableName tableName, boolean preserveSplits) {

        hTableDao.truncateTable(tableName,preserveSplits);

    }

    @Override
    public void disableTableAsync(TableName tableName) {

        hTableDao.disableTableAsync(tableName);

    }

    public void disableTableAsync(byte[] tableName) {

        disableTableAsync(TableName.valueOf(tableName));

    }

    public void disableTableAsync(String tableName) {

        disableTableAsync(TableName.valueOf(tableName));

    }

    @Override
    public boolean isTableEnabled(TableName tableName) {

        return hTableDao.isTableEnabled(tableName);

    }

    public boolean isTableEnabled(byte[] tableName) {

        return isTableEnabled(TableName.valueOf(tableName));

    }

    public boolean isTableEnabled(String tableName) {

        return isTableEnabled(TableName.valueOf(tableName));

    }

    @Override
    public boolean isTableDisabled(TableName tableName) {

        return hTableDao.isTableDisabled(tableName);

    }

    public boolean isTableDisabled(byte[] tableName) {

        return isTableDisabled(TableName.valueOf(tableName));

    }

    public boolean isTableDisabled(String tableName) {

        return isTableDisabled(TableName.valueOf(tableName));

    }

    @Override
    public boolean isTableAvailable(TableName tableName) {

        return hTableDao.isTableAvailable(tableName);

    }

    public boolean isTableAvailable(byte[] tableName) {

        return isTableAvailable(TableName.valueOf(tableName));

    }

    public boolean isTableAvailable(String tableName) {

        return isTableAvailable(TableName.valueOf(tableName));

    }

    @Override
    public Pair<Integer, Integer> getAlterStatus(TableName tableName) {
        return hTableDao.getAlterStatus(tableName);
    }

    public Pair<Integer, Integer> getAlterStatus(byte[] tableName) {
        return getAlterStatus(TableName.valueOf(tableName));
    }

    @Override
    public void addColumn(TableName tableName, HColumnDescriptor column) {

        hTableDao.addColumn(tableName,column);

    }

    public void addColumn(byte[] tableName, HColumnDescriptor column) {

        addColumn(TableName.valueOf(tableName),column);

    }

    public void addColumn(String tableName, HColumnDescriptor column) {

        addColumn(TableName.valueOf(tableName),column);

    }

    @Override
    public void deleteColumn(TableName tableName, byte[] columnName) {

        hTableDao.deleteColumn(tableName,columnName);

    }

    public void deleteColumn(byte[] tableName, byte[] columnName) {

        deleteColumn(TableName.valueOf(tableName),columnName);

    }

    public void deleteColumn(String tableName, byte[] columnName) {

        deleteColumn(TableName.valueOf(tableName),columnName);

    }

    @Override
    public void modifyColumn(TableName tableName, HColumnDescriptor descriptor) {

        hTableDao.modifyColumn(tableName,descriptor);

    }

    public void modifyColumn(byte[] tableName, HColumnDescriptor descriptor) {

        modifyColumn(TableName.valueOf(tableName),descriptor);

    }

    public void modifyColumn(String tableName, HColumnDescriptor descriptor) {

        modifyColumn(TableName.valueOf(tableName),descriptor);

    }

    @Override
    public void closeRegion(byte[] regionName, String serverName) {

        hTableDao.closeRegion(regionName,serverName);

    }

    public void closeRegion(String regionName, String serverName) {

        closeRegion(Bytes.toBytes(regionName),serverName);

    }

    public void closeRegion(ServerName sn, HRegionInfo hri) {

        hTableDao.closeRegion(sn,hri);

    }

    public boolean closeRegionWithEncodedRegionName(String encodedRegionName, String serverName) {
        return hTableDao.closeRegionWithEncodedRegionName(encodedRegionName,serverName);
    }

    @Override
    public void flushRegion(byte[] regionName) {

        hTableDao.flushRegion(regionName);

    }

    public void flush(TableName tableName) {

        hTableDao.flush(tableName);

    }

    public void flush(byte[] tableNameOrRegionName) {

        flush(TableName.valueOf(tableNameOrRegionName));

    }

    @Override
    public void compact(TableName tableName) {

        hTableDao.compact(tableName);

    }

    public void compact(TableName tableName, byte[] columnFamily) {

        hTableDao.compact(tableName,columnFamily);

    }

    public void compactRegion(byte[] regionName) {

        hTableDao.compactRegion(regionName);

    }

    public void compactRegion(byte[] regionName, byte[] columnFamily) {

        hTableDao.compactRegion(regionName,columnFamily);

    }

    public void compactRegionServer(ServerName sn, boolean major) {

        hTableDao.compactRegionServer(sn,major);

    }

    @Override
    public void majorCompact(TableName tableName) {

        hTableDao.majorCompact(tableName);

    }

    public void majorCompact(TableName tableName, byte[] columnFamily) {

        hTableDao.majorCompact(tableName,columnFamily);

    }

    public void majorCompactRegion(byte[] regionName) {

        hTableDao.majorCompactRegion(regionName);

    }

    public void majorCompactRegion(byte[] regionName, byte[] columnFamily) {

        hTableDao.majorCompactRegion(regionName,columnFamily);

    }

    @Override
    public void split(TableName tableName, byte[] splitPoint) {

        hTableDao.split(tableName,splitPoint);

    }

    public void split(TableName tableName) {

        split(tableName,null);

    }

    @Override
    public void splitRegion(byte[] regionName, byte[] splitPoint) {

        hTableDao.splitRegion(regionName,splitPoint);

    }

    public void splitRegion(byte[] regionName) {

        splitRegion(regionName,null);

    }

    @Override
    public void modifyTable(TableName tableName, HTableDescriptor htd) {

        hTableDao.modifyTable(tableName,htd);

    }

    public void modifyTable(byte[] tableName, HTableDescriptor htd) {

        modifyTable(TableName.valueOf(tableName),htd);

    }

    public void modifyTable(String tableName, HTableDescriptor htd) {

        modifyTable(TableName.valueOf(tableName),htd);

    }

    @Override
    public void snapshot(String snapshotName, TableName tableName, HBaseProtos.SnapshotDescription.Type type) {

        hTableDao.snapshot(snapshotName,tableName,type);

    }

    public void snapshot(String snapshotName, String tableName, HBaseProtos.SnapshotDescription.Type type) {

        snapshot(snapshotName,TableName.valueOf(tableName),type);

    }

    public void snapshot(String snapshotName, byte[] tableName, HBaseProtos.SnapshotDescription.Type type) {

        snapshot(snapshotName,TableName.valueOf(tableName),type);

    }

    public void snapshot(HBaseProtos.SnapshotDescription snapshot) {

        hTableDao.snapshot(snapshot);

    }

    public void snapshot(byte[] snapshotName, TableName tableName) {

        snapshot(Bytes.toString(snapshotName),tableName, HBaseProtos.SnapshotDescription.Type.FLUSH);

    }

    public void snapshot(byte[] snapshotName, byte[] tableName) {

        snapshot(Bytes.toString(snapshotName),TableName.valueOf(tableName), HBaseProtos.SnapshotDescription.Type.FLUSH);

    }

    public void snapshot(byte[] snapshotName, String tableName) {

        snapshot(Bytes.toString(snapshotName),TableName.valueOf(tableName),HBaseProtos.SnapshotDescription.Type.FLUSH);

    }

    public void snapshot(String snapshotName, String tableName) {

        snapshot(snapshotName,TableName.valueOf(tableName),HBaseProtos.SnapshotDescription.Type.FLUSH);

    }

    public void snapshot(String snapshotName, TableName tableName) {

        snapshot(snapshotName,tableName,HBaseProtos.SnapshotDescription.Type.FLUSH);

    }

    @Override
    public void restoreSnapshot(String snapshotName, boolean takeFailSafeSnapshot) {

        hTableDao.restoreSnapshot(snapshotName,takeFailSafeSnapshot);

    }

    public void restoreSnapshot(byte[] snapshotName, boolean takeFailSafeSnapshot) {

        restoreSnapshot(Bytes.toString(snapshotName),takeFailSafeSnapshot);

    }

    public void restoreSnapshot(String snapshotName) {

        restoreSnapshot(snapshotName,false);

    }

    public void restoreSnapshot(byte[] snapshotName) {

        restoreSnapshot(Bytes.toString(snapshotName));

    }

    @Override
    public void cloneSnapshot(String snapshotName, TableName tableName) {

        hTableDao.cloneSnapshot(snapshotName,tableName);

    }

    public void cloneSnapshot(byte[] snapshotName, TableName tableName) {

        cloneSnapshot(Bytes.toString(snapshotName),tableName);

    }

    public void cloneSnapshot(byte[] snapshotName, String tableName) {

        cloneSnapshot(Bytes.toString(snapshotName),TableName.valueOf(tableName));

    }

    public void cloneSnapshot(String snapshotName, String tableName) {

        cloneSnapshot(snapshotName,TableName.valueOf(tableName));

    }

    public void cloneSnapshot(String snapshotName, byte[] tableName) {

        cloneSnapshot(snapshotName,TableName.valueOf(tableName));

    }

    @Override
    public List<HBaseProtos.SnapshotDescription> listSnapshots() {

        return hTableDao.listSnapshots();
    }

    public List<HBaseProtos.SnapshotDescription> listSnapshots(Pattern pattern) {

        return hTableDao.listSnapshots(pattern);
    }

    public List<HBaseProtos.SnapshotDescription> listSnapshots(String regex) {
        return hTableDao.listSnapshots(Pattern.compile(regex));
    }

    @Override
    public void deleteSnapshot(String snapshotName) {

        hTableDao.deleteSnapshot(snapshotName);

    }

    public void deleteSnapshot(byte[] snapshotName) {

        deleteSnapshot(Bytes.toString(snapshotName));

    }

    @Override
    public void deleteSnapshots(Pattern pattern) {

        hTableDao.deleteSnapshots(pattern);

    }

    public void deleteSnapshots(String regex) {

        deleteSnapshots(Pattern.compile(regex));

    }

    @Override
    public void setQuota(QuotaSettings quota) {

        hTableDao.setQuota(quota);

    }

    public QuotaRetriever getQuotaRetriever(QuotaFilter filter) {

        return hTableDao.getQuotaRetriever(filter);

    }

    @Override
    public CoprocessorRpcChannel coprocessorService() {

        return hTableDao.coprocessorService();

    }

    public CoprocessorRpcChannel coprocessorService(ServerName sn) {

        return hTableDao.coprocessorService(sn);

    }

    @Override
    public void updateConfiguration(ServerName server) {

        hTableDao.updateConfiguration(server);

    }

    public void updateConfiguration() {

        hTableDao.updateConfiguration();

    }

    @Override
    public int getMasterInfoPort() {

        return hTableDao.getMasterInfoPort();

    }

    @Override
    public long getLastMajorCompactionTimestamp(TableName tableName) {

        return hTableDao.getLastMajorCompactionTimestamp(tableName);

    }

    public long getLastMajorCompactionTimestampForRegion(byte[] regionName) {

        return hTableDao.getLastMajorCompactionTimestampForRegion(regionName);

    }

    @Override
    public int getOperationTimeout() {

        return hTableDao.getOperationTimeout();

    }

    @Override
    public void abort(String why, Throwable e) {

        hTableDao.abort(why,e);

    }

    @Override
    public boolean isAborted() {

        return hTableDao.isAborted();

    }

    @Override
    public List<HRegionInfo> getOnlineRegions(ServerName sn) {

        return hTableDao.getOnlineRegions(sn);

    }

    @Override
    public void move(byte[] encodedRegionName, byte[] destServerName) {

        hTableDao.move(encodedRegionName,destServerName);

    }

    @Override
    public void assign(byte[] regionName) {

        hTableDao.assign(regionName);

    }

    @Override
    public void unassign(byte[] regionName, boolean force) {

        hTableDao.unassign(regionName,force);

    }

    @Override
    public void offline(byte[] regionName) {

        hTableDao.offline(regionName);

    }

    @Override
    public boolean setBalancerRunning(boolean on, boolean synchronous) {

        return hTableDao.setBalancerRunning(on, synchronous);

    }

    @Override
    public boolean balancer() {

        return hTableDao.balancer();

    }

    @Override
    public boolean isBalancerEnabled() {

        return hTableDao.isBalancerEnabled();

    }

    @Override
    public boolean enableCatalogJanitor(boolean enable) {

        return hTableDao.enableCatalogJanitor(enable);

    }

    @Override
    public int runCatalogScan() {

        return hTableDao.runCatalogScan();

    }

    @Override
    public boolean isCatalogJanitorEnabled() {

        return hTableDao.isCatalogJanitorEnabled();

    }

    @Override
    public void mergeRegions(byte[] encodedNameOfRegionA, byte[] encodedNameOfRegionB, boolean forcible) {

        hTableDao.mergeRegions(encodedNameOfRegionA,encodedNameOfRegionB,forcible);

    }


}
