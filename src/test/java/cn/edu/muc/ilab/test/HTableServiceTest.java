package cn.edu.muc.ilab.test;

import cn.edu.muc.ilab.hbaseadmin.dao.HTableDao;
import cn.edu.muc.ilab.test.util.TestSupport;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Raymond on 2017/3/29.
 */
public class HTableServiceTest  extends TestSupport {
    @Autowired
    private HTableDao hTableDao;

    @Test
    public void testListTable(){
        HTableDescriptor[] hTableDescriptors = hTableDao.listTables();
        System.out.println(hTableDescriptors.length);
    }
}
