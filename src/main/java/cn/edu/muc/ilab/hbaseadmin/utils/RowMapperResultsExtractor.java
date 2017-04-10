package cn.edu.muc.ilab.hbaseadmin.utils;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.springframework.data.hadoop.hbase.ResultsExtractor;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DBW on 2017/4/10.
 * 用于产生一个新的ResultsExtractor
 * 代码参考 org.springframework.data.hadoop.hbase.RowMapperResultsExtractor 类，因为此类非public
 * 故在外面定义一个新类，该工具类被HTableDaTaServiceImpl类使用
 */
public class RowMapperResultsExtractor<T> implements ResultsExtractor<List<T>> {

    private final RowMapper<T> rowMapper;

    /**
     * Create a new RowMapperResultSetExtractor.
     * @param rowMapper the RowMapper which creates an object for each row
     */
    public RowMapperResultsExtractor(RowMapper<T> rowMapper) {
        Assert.notNull(rowMapper, "RowMapper is required");
        this.rowMapper = rowMapper;
    }

    public List<T> extractData(ResultScanner results) throws Exception {
        List<T> rs = new ArrayList<T>();
        int rowNum = 0;
        for (Result result : results) {
            rs.add(this.rowMapper.mapRow(result, rowNum++));
        }
        return rs;
    }

}
