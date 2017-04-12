package cn.edu.muc.ilab.hbaseadmin.demo;

import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Autowired
    public HBaseAdmin hBaseAdmin;

    private String tableName = "Singleton_user";

    public static byte[] CF_INFO = Bytes.toBytes("cfInfo");

    private byte[] qUser = Bytes.toBytes("user");
    private byte[] qEmail = Bytes.toBytes("email");
    private byte[] qPassword = Bytes.toBytes("password");

    public List<User> findAll() {
        return hbaseTemplate.find(tableName, "cfInfo", (result, rowNum) -> new User(Bytes.toString(result.getValue(CF_INFO, qUser)),
                Bytes.toString(result.getValue(CF_INFO, qEmail)),
                Bytes.toString(result.getValue(CF_INFO, qPassword))));

    }

    public User save(final String userName, final String email,
                     final String password) {
        return hbaseTemplate.execute(tableName, new TableCallback<User>() {
            public User doInTable(HTableInterface table) throws Throwable {
                User user = new User(userName, email, password);
                Put p = new Put(Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qUser, Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qEmail, Bytes.toBytes(user.getEmail()));
                p.add(CF_INFO, qPassword, Bytes.toBytes(user.getPassword()));
                table.put(p);
                return user;

            }
        });
    }

    public boolean isTableExist(String tableName) {
        boolean flag = false;
        try {
            // 首先判断表是否存在
            if (hBaseAdmin.tableExists(tableName)) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
