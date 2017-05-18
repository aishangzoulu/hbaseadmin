package cn.edu.muc.ilab.hbaseadmin.service;

import cn.edu.muc.ilab.hbaseadmin.model.Greeting;

/**
 * Created by DBW on 2017/4/19.
 */
public interface RestService {

    Greeting greeting(String name);

}
