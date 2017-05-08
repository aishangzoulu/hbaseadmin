package cn.edu.muc.ilab.test;

import cn.edu.muc.ilab.hbaseadmin.service.HTableDataService;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import cn.edu.muc.ilab.test.util.TestSupport;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by Raymond on 2017/3/29.
 */

public class HTableServiceTest extends TestSupport {

    @Test
    public void createDeleteTableTest() {

        System.out.println("start table create  test");

        listTables();

        String tableName = "TestTable001";
        String columnFamily1 = "TestTableFamily001";
        String columnFamily2 = "TestTableFamily002";

        if (!hTableService.tableExists(tableName)) {

            hTableService.createTable(tableName, columnFamily1);

            System.out.println("create table:" + tableName);

            System.out.println("add a new column family:" + columnFamily2);

            hTableService.addColumn(tableName, new HColumnDescriptor(columnFamily2));

            if (hTableService.isTableAvailable(tableName)) {

                System.out.println("table " + tableName + " is available");

            }

            if (hTableService.isTableEnabled(tableName)) {

                System.out.println("table " + tableName + " is enabled");

            } else {

                hTableService.enableTable(tableName);

            }

        } else {

            deleteTableTest();

        }

    }

    @Test
    public void deleteTableTest() {

        System.out.println("start table delete test");

        String tableName = "TestTable001";
        String columnFamily = "TestTableFamily001";
        String columnFamily2 = "TestTableFamily002";

        listTables();

        if (hTableService.isTableEnabled(tableName)) {

            System.out.println("table " + tableName + " is  enabled");

        } else {

            System.out.println("table " + tableName + " is  disabled");

        }

        System.out.println("delete column family: " + tableName);

        hTableService.deleteColumn(tableName, Bytes.toBytes(columnFamily2));

        System.out.println("column family " + columnFamily2 + " is  deleted");

        hTableService.deleteTable(tableName);

        System.out.print("table " + tableName + " is deleted");

        listTables();

    }
    @Test
    public void listTest(){

        listTables();

    }




}
