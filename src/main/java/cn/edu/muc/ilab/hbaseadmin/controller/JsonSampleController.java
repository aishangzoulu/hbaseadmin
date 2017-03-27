package cn.edu.muc.ilab.hbaseadmin.controller;

import cn.edu.muc.ilab.hbaseadmin.model.Greeting;
import cn.edu.muc.ilab.hbaseadmin.service.GreetingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JsonSampleController {

    @Resource
    private GreetingService greetingService;

    @RequestMapping(value = "/testjson",method = RequestMethod.GET)
    public Greeting home(){
        return null;
    }
}
