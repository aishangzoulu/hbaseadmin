package cn.edu.muc.ilab.hbaseadmin.controller;

import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import cn.edu.muc.ilab.hbaseadmin.service.GreetingService;
import cn.edu.muc.ilab.hbaseadmin.service.RestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JsonSampleController {

    @Resource
    private RestService greetingService;

    @RequestMapping(value = "/testjson",method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name" ,defaultValue = "World")String name ){
        return greetingService.greeting(name);
    }


}
