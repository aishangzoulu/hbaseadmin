package cn.edu.muc.ilab.test;

import cn.edu.muc.ilab.hbaseadmin.service.HTableDataService;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import cn.edu.muc.ilab.test.util.TestSupport;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by Raymond on 2017/3/29.
 */

public class HTableServiceTest extends TestSupport {

    @Autowired
    private HTableService hTableService;

    @Autowired
    private HTableDataService hTableDataService;

    @Test
    public void testListTable() {

        HTableDescriptor[] hTableDescriptors = hTableService.listTables();
        for (HTableDescriptor hTableDescriptor : hTableDescriptors) {
            System.out.println(hTableDescriptor.getTableName().getNameAsString());
            ;
        }
    }

    @Test
    public void testCreateTable() {

        hTableService.createTable("TestTable001", "TestTableFamily001");
        testListTable();

    }

    @Test
    public void testDeleteTable() {


    }

    @Test
    public void putDataToTable() {

        String tableName = "TestTable001";
        String rowName = "test";
        String familyName = "TestTableFamily001";

        String qualifier = "列标识";
        byte[] value = Bytes.toBytes("这是一条数据");

        testListTable();

        String result = hTableDataService.get(tableName, rowName, familyName, qualifier,(result1, rowNum) -> {
            List<Cell> cells = result1.listCells();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            for (Cell cell :
                    cells) {
                sb.append(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
            }
            return sb.toString();
        });

        System.out.println("查询到的数据：");

        System.out.println(result);

    }
}
