package cn.edu.muc.ilab.hbaseadmin.dao.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.GreetingDao;
import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by DBW on 2017/4/19.
 */

@Repository
public class GreetingDaoImpl implements GreetingDao {


    @Override
    public Greeting greeting() {

        return null;

    }
}
