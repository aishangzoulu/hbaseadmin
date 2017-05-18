package cn.edu.muc.ilab.hbaseadmin.controller;

import cn.edu.muc.ilab.hbaseadmin.model.HTableModel;
import cn.edu.muc.ilab.hbaseadmin.model.ListModel;
import cn.edu.muc.ilab.hbaseadmin.service.HTableService;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DBW on 2017/4/19.
 * 关于HBase表 HTable的操作都在此Controller中实现
 */
@RestController
public class HTableController {


    @Resource
    private HTableService hTableService;

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public HTableModel getHTable(@RequestParam(value = "name", defaultValue = "null") String hTableName) {

        if (hTableName.equals("null")) {

            return null;

        }

        HTableModel model = new HTableModel(hTableName);

        HTableDescriptor descriptor = hTableService.getTableDescriptor(TableName.valueOf(hTableName));
        HColumnDescriptor[] columnFamilies = descriptor.getColumnFamilies();
        String[] families = new String[columnFamilies.length];
        for (int i = 0; i < columnFamilies.length; i++) {

            families[i] = columnFamilies[i].getNameAsString();

        }

        model.setFamilies(families);


        return model;
    }


    @RequestMapping(value = "/table_list", method = RequestMethod.GET)
    public ListModel listHTables() {

        List<String> list = new ArrayList<>();

        for (TableName tableName : hTableService.listTableNames()) {

            list.add(tableName.getNameAsString());

        }

        return new ListModel(list);

    }

    @RequestMapping(value = "/table_creation", method = RequestMethod.POST)
    public HTableModel createNewTable(@RequestBody HTableModel newTable) {

        hTableService.createTable(newTable.gethTableName(), newTable.getFamilies());

        if (hTableService.tableExists(newTable.gethTableName()))
            return newTable;

        return null;
    }



}