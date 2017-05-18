package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.RestDao;
import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import cn.edu.muc.ilab.hbaseadmin.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DBW on 2017/4/19.
 */
@Service
public class RestServiceImpl implements RestService {


    @Autowired
    private RestDao restDao;

    @Override
    public Greeting greeting(String name) {
        return restDao.greeting(name);
    }
}
