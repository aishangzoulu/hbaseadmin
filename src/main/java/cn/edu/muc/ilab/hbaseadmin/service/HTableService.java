package cn.edu.muc.ilab.hbaseadmin.service;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.protobuf.generated.HBaseProtos;
import org.apache.hadoop.hbase.util.Pair;

import javax.validation.constraints.NotNull;
import java.util.List;
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

    TableName[] listTableNames();
    TableName[] listTableNames(Pattern pattern);
    TableName[] listTableNames(String regex);
    TableName[] listTableNames(final Pattern pattern, final boolean includeSysTables);
    TableName[] listTableNames(final String regex, final boolean includeSysTables);

    void enableTable(final TableName tableName);
    void enableTable(final byte[] tableName);
    void enableTable(final String tableName);

    void enableTableAsync(final TableName tableName);
    void enableTableAsync(final byte[] tableName);
    void enableTableAsync(final String tableName);

    void disableTable(final TableName tableName);
    void disableTable(final byte[] tableName);
    void disableTable(final String tableName);

    void truncateTable(final TableName tableName, final boolean preserveSplits);

    void disableTableAsync(final TableName tableName);
    void disableTableAsync(final byte[] tableName);
    void disableTableAsync(final String tableName);

    boolean isTableEnabled(TableName tableName);
    boolean isTableEnabled(byte[] tableName);
    boolean isTableEnabled(String  tableName);

    boolean isTableDisabled(TableName tableName);
    boolean isTableDisabled(byte[] tableName);
    boolean isTableDisabled(String tableName);

    boolean isTableAvailable(TableName tableName);
    boolean isTableAvailable(byte[] tableName);
    boolean isTableAvailable(String tableName);

    Pair<Integer, Integer> getAlterStatus(final TableName tableName);
    Pair<Integer, Integer> getAlterStatus(final byte[] tableName);

    void addColumn(final TableName tableName, final HColumnDescriptor column);
    void addColumn(final byte[] tableName, final HColumnDescriptor column);
    void addColumn(final String  tableName, final HColumnDescriptor column);

    void deleteColumn(final TableName tableName, final byte [] columnName);
    void deleteColumn(final byte[] tableName, final byte [] columnName);
    void deleteColumn(final String  tableName, final byte [] columnName);

    void modifyColumn(final TableName tableName, final HColumnDescriptor descriptor);
    void modifyColumn(final byte[] tableName, final HColumnDescriptor descriptor);
    void modifyColumn(final String tableName, final HColumnDescriptor descriptor);

    void closeRegion(final byte [] regionName, final String serverName);
    void closeRegion(final String regionName, final String serverName);
    void closeRegion(final ServerName sn, final HRegionInfo hri);
    boolean closeRegionWithEncodedRegionName(final String encodedRegionName, final String serverName);

    void flushRegion(final byte[] regionName);
    void flush(final TableName tableName);
    void flush(final byte[] tableNameOrRegionName);

    void compact(final TableName tableName);
    void compact(final TableName tableName, final byte[] columnFamily);

    void compactRegion(final byte[] regionName);
    void compactRegion(final byte[] regionName, final byte[] columnFamily);
    void compactRegionServer(final ServerName sn, boolean major);

    void majorCompact(final TableName tableName);
    void majorCompact(final TableName tableName, final byte[] columnFamily);

    void majorCompactRegion(final byte[] regionName);
    void majorCompactRegion(final byte[] regionName, final byte[] columnFamily);

    void split(final TableName tableName, final byte [] splitPoint);
    void split(final TableName tableName);

    void splitRegion(final byte[] regionName, final byte [] splitPoint);
    void splitRegion(final byte[] regionName);

    void modifyTable(final TableName tableName, final HTableDescriptor htd);
    void modifyTable(final byte[] tableName, final HTableDescriptor htd);
    void modifyTable(final String tableName, final HTableDescriptor htd);

    void snapshot(final String snapshotName, final TableName tableName, HBaseProtos.SnapshotDescription.Type type);
    void snapshot(final String snapshotName, final String tableName, HBaseProtos.SnapshotDescription.Type type);
    void snapshot(final String snapshotName, final byte[] tableName, HBaseProtos.SnapshotDescription.Type type);
    void snapshot(HBaseProtos.SnapshotDescription snapshot);
    void snapshot(final byte[] snapshotName, final TableName tableName);
    void snapshot(final byte[] snapshotName, final byte[] tableName);
    void snapshot(final byte[] snapshotName, final String tableName);
    void snapshot(final String snapshotName,final String tableName);
    void snapshot(final String snapshotName,final TableName tableName);

    void restoreSnapshot(final String snapshotName, boolean takeFailSafeSnapshot);
    void restoreSnapshot(final byte[] snapshotName, boolean takeFailSafeSnapshot);
    void restoreSnapshot(final String snapshotName);
    void restoreSnapshot(final byte[] snapshotName);

    void cloneSnapshot(final String snapshotName, final TableName tableName);
    void cloneSnapshot(final byte[] snapshotName, final TableName tableName);
    void cloneSnapshot(final byte[] snapshotName, final String tableName);
    void cloneSnapshot(final String snapshotName, final String tableName);
    void cloneSnapshot(final String snapshotName, final byte[] tableName);

    List<HBaseProtos.SnapshotDescription> listSnapshots();
    List<HBaseProtos.SnapshotDescription> listSnapshots(Pattern pattern);
    List<HBaseProtos.SnapshotDescription> listSnapshots(String regex);

    void deleteSnapshot(final String snapshotName);
    void deleteSnapshot(final byte[] snapshotName);

    void deleteSnapshots(final Pattern pattern);
    void deleteSnapshots(final String regex);




}
