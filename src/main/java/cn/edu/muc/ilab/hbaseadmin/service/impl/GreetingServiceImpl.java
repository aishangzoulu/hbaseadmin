package cn.edu.muc.ilab.hbaseadmin.service.impl;

import cn.edu.muc.ilab.hbaseadmin.dao.GreetingDao;
import cn.edu.muc.ilab.hbaseadmin.service.GreetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GreetingServiceImpl implements GreetingService {


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private GreetingDao greetingDao;
}
