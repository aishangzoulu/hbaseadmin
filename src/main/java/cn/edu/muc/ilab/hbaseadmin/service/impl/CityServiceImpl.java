package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.CityDao;
import cn.edu.muc.ilab.hbaseadmin.model.City;
import cn.edu.muc.ilab.hbaseadmin.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 城市业务逻辑实现类
 *
 * Created by Raymond on 15/03/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
