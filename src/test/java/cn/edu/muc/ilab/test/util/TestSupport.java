package cn.edu.muc.ilab.test.util;

import cn.edu.muc.ilab.hbaseadmin.service.HTableDataService;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Raymond on 2017/3/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSupport {

    @Autowired
    protected HTableDataService hTableDataService;

    @Autowired
    protected HTableService hTableService;

    protected void listTables(){

        HTableDescriptor[] descriptors = hTableService.listTables();

        for (HTableDescriptor descriptor : descriptors) {

            System.out.println(descriptor.getNameAsString());

        }

    }

}
