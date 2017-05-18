package cn.edu.muc.ilab.hbaseadmin.dao;

import cn.edu.muc.ilab.hbaseadmin.model.Greeting;

/**
 * Created by DBW on 2017/4/19.
 *
 */
public interface RestDao {

    Greeting greeting(String name);

}
