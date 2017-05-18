package cn.edu.muc.ilab.test;

import cn.edu.muc.ilab.test.util.TestSupport;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.util.List;

/**
 * Created by DBW on 2017/4/12.
 * 对HTable的数据 增删改查进行单元测试
 * 对应的Service:HTableDataService
 */
public class HTableDataTest extends TestSupport {

    private String tableName = "TestTable001";
    private String rowName = "test";
    private String familyName = "TestTableFamily001";
    private String qualifier = "my_qualifier";

    @Test
    public void getDataTest() {

        listTables();

        String result = hTableDataService.get(tableName, rowName, familyName, qualifier, (result1, rowNum) -> {
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

    @Test
    public void putDataTest() {

        byte[] values = Bytes.toBytes("插入的数据");

        hTableDataService.put(tableName, rowName, familyName,qualifier,values);



    }

}
