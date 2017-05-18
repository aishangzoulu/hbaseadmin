package cn.edu.muc.ilab.hbaseadmin.dao.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.RestDao;
import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by DBW on 2017/4/19.
 */
@Repository
public class RestDaoImpl implements RestDao {

    private AtomicLong mAtomicLong;
    private String template = "hello,%s!";


    public RestDaoImpl(){

        mAtomicLong = new AtomicLong(0);

    }

    @Override
    public Greeting greeting(String name) {
        return new Greeting(mAtomicLong.incrementAndGet(),String.format(template,name));
    }
}
