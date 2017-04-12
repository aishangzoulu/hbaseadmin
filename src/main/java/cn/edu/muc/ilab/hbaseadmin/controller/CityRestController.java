package cn.edu.muc.ilab.hbaseadmin.controller;

import cn.edu.muc.ilab.hbaseadmin.model.City;
import cn.edu.muc.ilab.hbaseadmin.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Raymond on 15/03/2017.
 */
@RestController
public class CityRestController {

    @Resource
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }



}
