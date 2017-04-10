package cn.edu.muc.ilab;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
public class WebGisApplication {

    @Autowired
    private HBaseAdmin hBaseAdmin;

	public static void main(String[] args) {

		SpringApplication.run(WebGisApplication.class, args);
        Configuration conf = HBaseConfiguration.create();



        byte[] row = Bytes.toBytes("myLittleRow");
        byte[] family = Bytes.toBytes("myFamily");
        byte[] qualifier = Bytes.toBytes("someQualifier");

		try {

			Connection connection = ConnectionFactory.createConnection(conf);

            Table table =  connection.getTable(TableName.valueOf("test"));

            //put
            Put p = new Put(row);

            Cell cell = CellUtil.createCell(family,qualifier);

            p.add(cell);
            table.put(p);

            //get
            Get g = new Get(row);

            Result r = table.get(g);

            byte[] value = r.getValue(family,qualifier);
            String valStr = value.toString();
            System.out.println("GET"+valStr);

            //scan

            Scan s = new Scan();
            s.addColumn(family,qualifier);
            ResultScanner rs = table.getScanner(s);

            for (Result result :
                    rs) {
                System.out.println("Found row:"+result);
            }

            rs.close();
            table.close();
            connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
