package cn.edu.muc.ilab.hbaseadmin.service;


import cn.edu.muc.ilab.hbaseadmin.model.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by Raymond on 15/03/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
