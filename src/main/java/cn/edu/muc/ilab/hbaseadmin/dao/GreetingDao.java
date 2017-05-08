package cn.edu.muc.ilab.hbaseadmin.dao;

import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GreetingDao {

    Greeting greeting();

}
